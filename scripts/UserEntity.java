package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "", catalog = "")
public class UserEntity {

    @Basic
    @Column(name = "user_number", nullable = false)
    private long userNumber;
    @Basic
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Basic
    @Column(name = "username", nullable = false)
    private String username;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Basic
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;
    @Basic
    @Column(name = "join_datetime", nullable = false)
    private java.sql.Timestamp joinDatetime;
    @Basic
    @Column(name = "withdrawal_datetime", nullable = false)
    private java.sql.Timestamp withdrawalDatetime;
    @Basic
    @Column(name = "login_fail_count", nullable = false)
    private long loginFailCount;
    @Basic
    @Column(name = "last_login_ip", nullable = false)
    private String lastLoginIp;
    @Basic
    @Column(name = "last_login_datetime", nullable = false)
    private java.sql.Timestamp lastLoginDatetime;
    @Basic
    @Column(name = "last_updated_user_number", nullable = false)
    private long lastUpdatedUserNumber;
    @Basic
    @Column(name = "last_updated_datetime", nullable = false)
    private java.sql.Timestamp lastUpdatedDatetime;

}
