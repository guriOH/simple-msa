package com.example.bbscore.domain.article.persistence.repository;

import com.example.bbscore.domain.article.persistence.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<List<Article>> findAllByBoardId(Long boardId);
}
