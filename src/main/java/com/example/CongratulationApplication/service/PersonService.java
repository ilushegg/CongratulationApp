package com.example.CongratulationApplication.service;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.domain.User;
import com.example.CongratulationApplication.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    @Value("${upload.path}")
    private String uploadPath;

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo){
        this.personRepo = personRepo;
    }

    public boolean addPerson(String name, MultipartFile file, LocalDate birthday, User user) throws IOException {
        Person person = new Person();
        person.setName(name);
        saveFile(file, person);
        person.setBirthday(birthday);
        person.setUser(user);
        personRepo.save(person);
        return true;
    }

    public boolean editPerson(Person person, String name, MultipartFile file, LocalDate date) throws IOException {
        person.setName(name);
        person.setBirthday(date);
        saveFile(file, person);
        personRepo.save(person);
        return true;
    }

    private void saveFile(MultipartFile file, Person person) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            person.setFilename(resultFilename);

        }
    }
}
