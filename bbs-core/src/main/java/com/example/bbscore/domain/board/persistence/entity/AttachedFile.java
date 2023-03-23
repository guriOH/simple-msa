package com.example.bbscore.domain.board.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "attached_file", schema = "", catalog = "")
public class AttachedFile {

    @Id
    @Basic
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "attached_file_name", nullable = false)
    private String attachedFileName;
    @Basic
    @Column(name = "attached_file_extension", nullable = false)
    private String attachedFileExtension;
    @Basic
    @Column(name = "attached_file_size", nullable = false)
    private long attachedFileSize;
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
