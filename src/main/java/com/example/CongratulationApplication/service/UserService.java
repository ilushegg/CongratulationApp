package com.example.CongratulationApplication.service;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.PersonRepo;
import com.example.CongratulationApplication.repos.UserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final PersonRepo personRepo;

    public Map<User, Map<Boolean, String>> map = new HashMap<>();

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, @Lazy MailService mailService, PersonRepo personRepo){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
        this.personRepo = personRepo;
        birthdayPersonsString();
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }

    public boolean add(User user){
        User userFromDb = userRepo.findByEmail(user.getEmail());

        if(userFromDb != null ){
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);
        String link = "http://localhost:8080/activate/" + user.getActivationCode();
        sendConfirm(user, link);
        return true;
    }

    public void sendConfirm(User user, String link){
        String message = String.format(
                "Hello, %s!" +
                        "Welcome to the application where you will never forget about your friends' birthday!" +
                        "Please follow the following link to confirm your email address: %s",
                user.getUsername(), link
        );
        mailService.send(user.getEmail(), "Welcome to the app", message);
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);
        if(user == null){
            return  false;
        }
        user.setActivationCode(null);
        userRepo.save(user);
        return true;
    }

    public void birthdayPersonsString(){
        List<User> users = userRepo.findAll();
        for(User user : users){
            List<Person> birthdayPersons = getBirthdayPersons((User) user);
            String birthdayPersonsStr = "";
            for(Person person : birthdayPersons){
                birthdayPersonsStr += person.getName();
            }
            Map<Boolean, String> temp = new HashMap<>();
            temp.put(true, birthdayPersonsStr);
            map.put(user, temp);
        }
    }

    public List<Person> getBirthdayPersons(User user) {
        List<Person> persons = personRepo.findAllByUser(user);
        List<Person> birthdayPersons = new ArrayList<>();
        for(Person person : persons){
            if(person.getBirthday().getDayOfMonth() == LocalDate.now().getDayOfMonth() && person.getBirthday().getMonth() == LocalDate.now().getMonth()) {
                birthdayPersons.add(person);
            }
        }
        return birthdayPersons;
    }

    public void userSettings(User user, LocalTime time, Boolean allow){
        user.setSendingTime(time);
        user.setAllowSend(allow);
        userRepo.save(user);
    }
}
