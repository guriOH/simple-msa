package com.example.bbsadmin.domain.comment;

import com.example.bbscore.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class CommentController {

    private final ArticleService articleService;

    @GetMapping("/{boardId}")
    public void search(@PathVariable Long boardId){
        articleService.getArticles(boardId);
    }

    @PutMapping("/{articleId}")
    public void hideArticle(@PathVariable Long articleId){
        articleService.hide(articleId);
    }

}
