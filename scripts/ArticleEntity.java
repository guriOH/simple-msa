package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "article", schema = "", catalog = "")
public class ArticleEntity {

    @Basic
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "board_id", nullable = false)
    private long boardId;
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
    private String isPublic;
    @Basic
    @Column(name = "is_deleted", nullable = false)
    private String isDeleted;
    @Basic
    @Column(name = "registered_user_number", nullable = false)
    private long registeredUserNumber;
    @Basic
    @Column(name = "registered_datetime", nullable = false)
    private java.sql.Timestamp registeredDatetime;
    @Basic
    @Column(name = "last_updated_user_number", nullable = false)
    private long lastUpdatedUserNumber;
    @Basic
    @Column(name = "last_updated_datetime", nullable = false)
    private java.sql.Timestamp lastUpdatedDatetime;
    @Basic
    @Column(name = "board_id1", nullable = false)
    private long boardId1;

}
