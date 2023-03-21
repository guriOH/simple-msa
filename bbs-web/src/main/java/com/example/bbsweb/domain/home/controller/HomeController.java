package com.example.bbsweb.domain.home.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
@RequestMapping("/home")
public class HomeController {


    @GetMapping
    public String getHome(HttpServletRequest request){
        return "/contents/home";
    }
}
