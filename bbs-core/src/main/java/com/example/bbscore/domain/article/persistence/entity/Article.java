package com.example.bbscore.domain.article.persistence.entity;

import com.example.bbscore.domain.board.persistence.entity.Board;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "article", schema = "", catalog = "")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    @Basic
    @Column(name = "article_title", nullable = false)
    private String articleTitle;
    @Basic
    @Column(name = "article_contents", nullable = false)
    private String articleContents;
    @Basic
    @Column(name = "article_category", nullable = false)
    private String articleCategory;
    @Basic
    @Column(name = "hit_count", nullable = false)
    private long hitCount;
    @Basic
    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;
    @Basic
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;
    @Basic
    @Column(name = "registered_user_number", nullable = false)
    private long registeredUserNumber;
    @Basic
    @Column(name = "registered_datetime", nullable = false)
    private Date registeredDatetime;
    @Basic
    @Column(name = "last_updated_user_number", nullable = false)
    private long lastUpdatedUserNumber;
    @Basic
    @Column(name = "last_updated_datetime", nullable = false)
    private Date lastUpdatedDatetime;

}
