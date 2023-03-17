package com.example.bbsweb.domain.article.controller;


import com.example.bbscore.domain.article.dto.ArticleInsertDto;
import com.example.bbscore.domain.article.service.ArticleService;
import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.dto.BoardUpdateDto;
import com.example.bbscore.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/{boardId}/register")
    public String register(
            @PathVariable Long boardId,
            @RequestBody ArticleInsertDto articleInsertDto){
        articleService.register(boardId, articleInsertDto);
        return "/board";
    }

//    @PostMapping("/update/{boardId}")
//    public String update(@PathVariable Long boardId,
//                         @RequestBody BoardUpdateDto boardUpdateDto){
//        articleService.update(boardId, boardUpdateDto);
//        return "/board";
//    }
}
