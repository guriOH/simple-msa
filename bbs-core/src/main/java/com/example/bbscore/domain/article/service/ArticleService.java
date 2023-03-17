package com.example.bbscore.domain.article.service;

import com.example.bbscore.base.exception.BbsException;
import com.example.bbscore.domain.article.dto.ArticleInsertDto;
import com.example.bbscore.domain.article.dto.ArticleUpdateDto;
import com.example.bbscore.domain.article.persistence.entity.Article;
import com.example.bbscore.domain.article.persistence.repository.ArticleRepository;
import com.example.bbscore.domain.board.dto.BoardInsertDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void register(Long boardId, ArticleInsertDto articleInsertDto) {

        Article article = new Article();
        article.setBoardId(boardId);
        article.setArticleTitle(articleInsertDto.getArticleTitle());
        article.setArticleContents(articleInsertDto.getArticleContents());
        article.setArticleCategory(articleInsertDto.getArticleCategory());
        article.setHitCount(0);
        article.setIsPublic(articleInsertDto.getIsPublic());
        article.setIsDeleted(false);

        article.setRegisteredUserNumber(1L);
        article.setRegisteredDatetime(new Date());
        article.setLastUpdatedUserNumber(1L);
        article.setLastUpdatedDatetime(new Date());

        articleRepository.save(article);
    }


    @Transactional
    public void delete(Long articleId){

        Article article = articleRepository.findById(articleId).orElseThrow(() -> new BbsException("Could not find article"));

        article.setIsDeleted(true);
    }

    @Transactional
    public void modify(ArticleUpdateDto articleUpdateDto){

        Article article = articleRepository.findById(articleUpdateDto.getArticleId()).orElseThrow(() -> new BbsException("Could not find article"));

        article.setArticleTitle(articleUpdateDto.getArticleTitle());
        article.setArticleContents(articleUpdateDto.getArticleContents());
        article.setArticleCategory(articleUpdateDto.getArticleCategory());
        article.setIsPublic(articleUpdateDto.getIsPublic());
    }

}
