package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.PersonRepo;
import com.example.CongratulationApplication.service.PersonService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



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
    public String persons(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("persons", personRepo.findAllByUser(user));
        return "persons";
    }

    @GetMapping("/persons/edit/{person}")
    public String editForm(@PathVariable Person person, Model model){
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/persons/edit/{person}")
    public String editPerson(@RequestParam String name, @RequestParam MultipartFile file, @RequestParam String birthday, @AuthenticationPrincipal User user, @PathVariable Person person) throws IOException {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date = dateTimeFormat.parse(birthday, LocalDate::from);

        personService.editPerson(person, name, file, date);
        return "redirect:/persons";
    }


}
