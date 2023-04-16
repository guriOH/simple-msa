package com.example.bbscore.domain.article.service;

import com.example.bbscore.base.exception.BbsException;
import com.example.bbscore.domain.article.dto.ArticleDetailDto;
import com.example.bbscore.domain.article.dto.ArticleInsertDto;
import com.example.bbscore.domain.article.dto.ArticleListDto;
import com.example.bbscore.domain.article.dto.ArticleUpdateDto;
import com.example.bbscore.domain.article.persistence.entity.Article;
import com.example.bbscore.domain.article.persistence.repository.ArticleRepository;
import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.persistence.entity.Board;
import com.example.bbscore.domain.board.persistence.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final BoardRepository boardRepository;

    public ArticleListDto getArticles(Long boardId) throws Exception {

        Board board = boardRepository.findById(boardId).orElse(null);

        if(!ObjectUtils.isEmpty(board)){
            List<Article> articles = new ArrayList<Article>();
            try {
                articles = articleRepository.findAllByBoardId(boardId)
                        .orElseThrow(() -> new Exception("No articles found"));
            }catch (Exception e) {

            }

            return ArticleListDto.builder()
                    .boardId(String.valueOf(board.getId()))
                    .boardName(board.getName())
                    .articles(articles.stream().map( x ->{
                        return ArticleDetailDto.builder()
                                .title(x.getArticleTitle())
                                .createdAt(x.getRegisteredDatetime())
                                .createdBy(String.valueOf(x.getRegisteredUserNumber()))
                                .build();
                    }).collect(Collectors.toList()))
                    .build();
        }

        return ArticleListDto.builder().build();

    }

    public void register(Long boardId, ArticleInsertDto articleInsertDto) throws Exception {

        Optional<Board> boardOptional = boardRepository.findById(boardId);

        if(!boardOptional.isPresent()) throw new Exception("Board not found");

        Article article = new Article();
        article.setBoard(boardOptional.get());
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


    @Transactional
    public void hide(Long articleId){
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new BbsException("Could not find article"));

        article.setIsPublic(false);
    }

}
