package com.example.bbsweb.domain.auth.controller;


import com.example.bbscore.domain.auth.dto.SignUpRequestDto;
import com.example.bbscore.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignUpRequestDto signUpRequestDto){
        return authService.signUp(signUpRequestDto);
    }
}
