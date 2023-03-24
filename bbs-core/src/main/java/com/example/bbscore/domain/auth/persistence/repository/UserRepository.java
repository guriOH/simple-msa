package com.example.bbscore.domain.auth.persistence.repository;


import com.example.bbscore.domain.auth.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String emailAddress);
}
