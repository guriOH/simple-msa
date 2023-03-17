package com.example.bbscore.domain.article.persistence.repository;

import com.example.bbscore.domain.article.persistence.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
