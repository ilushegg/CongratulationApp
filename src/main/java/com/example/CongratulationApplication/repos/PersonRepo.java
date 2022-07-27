package com.example.CongratulationApplication.repos;

import com.example.CongratulationApplication.domain.Person;
import com.example.CongratulationApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByName(String name);

    List<Person> findAllByUser(User user);
}
