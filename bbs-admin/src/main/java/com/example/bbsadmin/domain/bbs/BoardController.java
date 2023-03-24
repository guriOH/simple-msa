package com.example.bbsadmin.domain.bbs;


import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.dto.BoardUpdateDto;
import com.example.bbscore.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/bbs")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public void search(){
        boardService.getBoards();
    }


    @PostMapping("/regist-bbs")
    public void register(@RequestBody BoardInsertDto boardInsertDto){
        boardService.register(boardInsertDto);
    }

    @PostMapping("/modify-bbs")
    public void update(@RequestBody BoardUpdateDto boardUpdateDto){
        boardService.update(boardUpdateDto);
    }

}
