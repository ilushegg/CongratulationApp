package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.PersonRepo;
import com.example.CongratulationApplication.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final UserService userService;

    public MainController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String main(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainPersons(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("persons", userService.getBirthdayPersons(user));
        return "main";
    }
}
