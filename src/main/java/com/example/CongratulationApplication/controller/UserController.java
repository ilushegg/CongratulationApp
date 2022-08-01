package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.IOException;
import java.time.LocalTime;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("settings")
    public String settingsForm(
            @AuthenticationPrincipal User user,
            Model model)
    {
        model.addAttribute("user", user);
        return "settings";
    }

    @PostMapping("settings")
    public String settingsSave(
            @AuthenticationPrincipal User user,
            @RequestParam LocalTime sendingTime,
            @RequestParam("allowSend") String allowSend,
            Model model)
    {
        Boolean answer;
        if(allowSend.equals("false")) {
            answer = false;
        }
        else{
            answer = true;
        }
        userService.userSettings(user, sendingTime, answer);
        userService.birthdayPersonsString();
        return "redirect:/user/settings";
    }

    @GetMapping("profile")
    public String profileForm(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("profile")
    public String profileSave(Model model, @AuthenticationPrincipal User user, MultipartFile avatar, @RequestParam String email, @RequestParam String password) throws IOException {
        userService.editUser(user, avatar, email, password);
        model.addAttribute("user", user);
        return "profile";
    }

}
