package com.example.bbsadmin.domain.article;


import com.example.bbscore.domain.article.service.ArticleService;
import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.dto.BoardUpdateDto;
import com.example.bbscore.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{boardId}")
    public void search(@PathVariable Long boardId){
//        articleService.getArticles(boardId);
    }

    @PutMapping("/{articleId}")
    public void hideArticle(@PathVariable Long articleId){
        articleService.hide(articleId);
    }

}
