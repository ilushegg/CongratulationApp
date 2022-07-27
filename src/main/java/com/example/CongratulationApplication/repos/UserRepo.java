package com.example.CongratulationApplication.repos;

import com.example.CongratulationApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByActivationCode(String activationCode);
}
