package com.example.bbsweb.domain.board.controller;


import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.dto.BoardUpdateDto;
import com.example.bbscore.domain.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;



@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/bbs")
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public String getList(Model model){
        model.addAttribute("bbs_list", boardService.getBoards());
        return "/contents/bbs";
    }

    @PostMapping("/register")
    public String register(@RequestBody BoardInsertDto boardInsertDto){
        boardService.register(boardInsertDto);
        return "redirect:/contents/bbs";
    }

    @DeleteMapping("/{boardId}")
    public String delete(@PathVariable long boardId){
        boardService.delete(boardId);
        return "/contents/bbs";
    }

//    @PostMapping("/update/{boardId}")
//    public String update(@PathVariable Long boardId,
//                         @RequestBody BoardUpdateDto boardUpdateDto){
//        boardService.update(boardId, boardUpdateDto);
//        return "/board";
//    }

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
