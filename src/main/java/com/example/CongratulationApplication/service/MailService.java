package com.example.CongratulationApplication.service;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.PersonRepo;
import com.example.CongratulationApplication.repos.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender mailSender;
    private final PersonRepo personRepo;
    private final UserService userService;
    private final UserRepo userRepo;

    public MailService(JavaMailSender mailSender, PersonRepo personRepo, UserService userService, UserRepo userRepo){
        this.mailSender = mailSender;
        this.personRepo = personRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }


    public void send(String emailTo, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    @Scheduled(initialDelay = 1000L, fixedDelay = 3000L)
    public void sendInterval(){
        System.out.println("INTERVAL2");

        for(Map.Entry<User, Map<Boolean, String>> entry : userService.map.entrySet()){
            Map<Boolean, String> personsTemp = entry.getValue();
            String persons = "";
            Boolean sent = false;
            for(Map.Entry<Boolean, String> tempEntry : personsTemp.entrySet()){
                persons = tempEntry.getValue();
                sent = tempEntry.getKey();
            }
            if(!persons.isEmpty() && sent){
                String message = String.format(
                        "Hi, %s. Do not forget! \n" +
                                "It's your friends' birthday today: \n" +
                                "%s\n\n\n" +
                                "You received this message because you've registered or accepted our invitation to receive emails from CONGRATULATION APPLICATION.",
                        entry.getKey().getUsername(), persons);
                send(entry.getKey().getEmail(), "It's your friends' birthday", message);
                Map<Boolean, String> temp = new HashMap<>();
                temp.put(false, persons);
                entry.setValue(temp);
                System.out.println(message);
            }
        }




    }

}
