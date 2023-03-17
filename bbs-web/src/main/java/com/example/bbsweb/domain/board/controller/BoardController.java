package com.example.bbsweb.domain.board.controller;


import com.example.bbscore.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinylog.Logger;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/test")
    public String test(Model model) {

        model.addAttribute("hello", "안뇽");
        return "/hello";
    }

    @GetMapping("/test2")
    public void test2(){
        Logger.trace("Hello World!");
        Logger.debug("Hello World!");
        Logger.info("Hello World!");
        Logger.warn("Hello World!");
        Logger.error("Hello World!");
    }
}
