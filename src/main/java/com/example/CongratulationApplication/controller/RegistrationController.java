package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            model.addAttribute("message", "User successfully activated");
        }
        else{
            model.addAttribute("message", "Activation code is not found!");
        }
        return "redirect:/login";
    }
}
