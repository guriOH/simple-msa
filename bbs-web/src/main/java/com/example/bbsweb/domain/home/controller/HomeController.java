package com.example.bbsweb.domain.home.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public String getHome(HttpServletRequest request){
        return "/contents/home";
    }
}
