package com.example.bbscore.domain.auth.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "", catalog = "")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_number", nullable = false)
    private long userNumber;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Basic
    @Column(name = "join_datetime", nullable = false)
    private Date joinDatetime;
    @Basic
    @Column(name = "login_fail_count", nullable = false)
    private long loginFailCount;
    @Basic
    @Column(name = "last_updated_datetime", nullable = false)
    private Date lastUpdatedDatetime;

}
