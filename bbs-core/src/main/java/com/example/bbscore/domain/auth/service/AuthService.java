package com.example.bbscore.domain.auth.service;


import com.example.bbscore.domain.auth.dto.LoginRequestDto;
import com.example.bbscore.domain.auth.dto.SignUpRequestDto;
import com.example.bbscore.domain.auth.persistence.entity.User;
import com.example.bbscore.domain.auth.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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
        user.setJoinDatetime(new Date());
        user.setLoginFailCount(0L);
        user.setLastUpdatedDatetime(new Date());


        userRepository.save(user);
        return signUpRequestDto.getEmail();
    }

    public boolean login(LoginRequestDto loginRequestDto) {
        Optional<User> user = userRepository.findByEmailAddress(loginRequestDto.getEmail());

        if(user.isPresent()) {
            return passwordEncoder.matches(loginRequestDto.getPassword(), user.get().getPassword());
        }else{
            return false;
        }
    }


    public User findUserByEmailAddress(String emailAddress){
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);

        if(user.isPresent()) {
            return user.get();
        }else{
            return null;
        }
    }
}
