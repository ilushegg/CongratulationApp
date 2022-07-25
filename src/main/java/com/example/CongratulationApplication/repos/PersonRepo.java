package com.example.CongratulationApplication.repos;

import com.example.CongratulationApplication.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByName(String name);
}
