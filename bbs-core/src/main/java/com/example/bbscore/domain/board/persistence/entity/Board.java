package com.example.bbscore.domain.board.persistence.entity;


import com.example.bbscore.base.entity.BaseEntity;
import com.example.bbscore.domain.article.persistence.entity.Article;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    private String description;

    private boolean isDeleted;

    private boolean isAllowedComment;

    private boolean isAllowedAttach;

    @OneToMany(mappedBy = "board")
    private List<Article> articles;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
