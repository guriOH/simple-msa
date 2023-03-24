package com.example.bbscore.domain.auth.service;


import com.example.bbscore.domain.auth.dto.SignUpRequestDto;
import com.example.bbscore.domain.auth.persistence.entity.User;
import com.example.bbscore.domain.auth.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String signUp(SignUpRequestDto signUpRequestDto){

        boolean existUser = userRepository.existsByEmailAddress(signUpRequestDto.getEmail());

        if(existUser) return null;

        User user = new User();
        user.setEmailAddress(signUpRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));

        userRepository.save(user);
        return signUpRequestDto.getEmail();
    }
}
