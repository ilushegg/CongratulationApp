package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.PersonRepo;
import com.example.CongratulationApplication.service.PersonService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



@Controller
public class PersonController {
    private final PersonService personService;
    private final PersonRepo personRepo;

    public PersonController(PersonService personService, PersonRepo personRepo){
        this.personRepo = personRepo;
        this.personService = personService;
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam String name, @RequestParam MultipartFile file, @RequestParam String birthday, @AuthenticationPrincipal User user) throws IOException {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date = dateTimeFormat.parse(birthday, LocalDate::from);

        personService.addPerson(name, file, date, user);
        return "redirect:/persons";
    }

    @GetMapping("/persons")
    public String persons(Model model){
        model.addAttribute("persons", personRepo.findAll());
        return "persons";
    }
}
