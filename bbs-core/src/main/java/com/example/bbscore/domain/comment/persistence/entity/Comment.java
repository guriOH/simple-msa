package com.example.bbscore.domain.comment.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "comment", schema = "", catalog = "")
public class Comment {

    @Id
    @Basic
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "is_deleted", nullable = false)
    private String isDeleted;
    @Basic
    @Column(name = "contents", nullable = false)
    private String contents;
    @Basic
    @Column(name = "registered_user_number", nullable = false)
    private long registeredUserNumber;
    @Basic
    @Column(name = "registered_datetime", nullable = false)
    private Timestamp registeredDatetime;
    @Basic
    @Column(name = "article_id", nullable = false)
    private long articleId;

}
