package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "attached_file", schema = "", catalog = "")
public class AttachedFileEntity {

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
    private java.sql.Timestamp registeredDatetime;
    @Basic
    @Column(name = "article_id", nullable = false)
    private long articleId;

}
