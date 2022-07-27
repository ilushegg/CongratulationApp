package com.example.CongratulationApplication.service;

import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.UserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, MailService mailService){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
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
}
