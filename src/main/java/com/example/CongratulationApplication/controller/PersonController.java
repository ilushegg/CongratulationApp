package com.example.CongratulationApplication.controller;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.service.PersonService;
import com.example.CongratulationApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/add")
    public String persons(Model model){
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(Person person, @RequestParam MultipartFile file, @RequestParam String birthday) throws IOException {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date = dateTimeFormat.parse(birthday, LocalDate::from);

        personService.addPerson(person, file, date);
        return "persons";
    }
}
