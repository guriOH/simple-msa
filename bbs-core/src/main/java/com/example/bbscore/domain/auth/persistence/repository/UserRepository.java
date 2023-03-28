package com.example.bbscore.domain.auth.persistence.repository;


import com.example.bbscore.domain.auth.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findByEmailAddress(String emailAddress);
}
