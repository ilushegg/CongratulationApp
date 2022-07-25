package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationPage(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user){
        userService.add(user);
        return "redirect:/login";
    }
}
