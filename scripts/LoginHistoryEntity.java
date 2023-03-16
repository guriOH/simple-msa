package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "login_history", schema = "", catalog = "")
public class LoginHistoryEntity {

    @Basic
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "is_sucess", nullable = false)
    private String isSucess;
    @Basic
    @Column(name = "access_login_ip", nullable = false)
    private String accessLoginIp;
    @Basic
    @Column(name = "access_login_datetime", nullable = false)
    private java.sql.Timestamp accessLoginDatetime;
    @Basic
    @Column(name = "user_number", nullable = false)
    private long userNumber;

}
