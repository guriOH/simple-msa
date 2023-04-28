package com.example.bbsweb.domain.article.controller;


import com.example.bbscore.domain.article.dto.ArticleInsertDto;
import com.example.bbscore.domain.article.service.ArticleService;
import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.dto.BoardUpdateDto;
import com.example.bbscore.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{boardId}")
    public String articles(Model model, @PathVariable Long boardId) throws Exception {
        model.addAttribute("articleList", articleService.getArticles(boardId));
        return "/board/detail";
    }

    @PostMapping("/{boardId}/register")
    public String register(
            Model model,
            @PathVariable Long boardId,
            @RequestBody ArticleInsertDto articleInsertDto) throws Exception {
        articleService.register(boardId, articleInsertDto);

        model.addAttribute("articleList", articleService.getArticles(boardId));
        return "/board/detail";
    }

    @GetMapping("/detail/{articleId}")
    public String detailArticle(){
        return null;
    }
}
