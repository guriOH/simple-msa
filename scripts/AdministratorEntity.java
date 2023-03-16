package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "administrator", schema = "", catalog = "")
public class AdministratorEntity {

    @Basic
    @Column(name = "number", nullable = false)
    private long number;
    @Basic
    @Column(name = "admin_id", nullable = false)
    private String adminId;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "admin_name", nullable = false)
    private String adminName;
    @Basic
    @Column(name = "admin_status", nullable = false)
    private String adminStatus;
    @Basic
    @Column(name = "join_datetime", nullable = false)
    private java.sql.Timestamp joinDatetime;
    @Basic
    @Column(name = "withdrawal_datetime", nullable = false)
    private java.sql.Timestamp withdrawalDatetime;
    @Basic
    @Column(name = "last_login_ip", nullable = false)
    private String lastLoginIp;
    @Basic
    @Column(name = "last_login_datetime", nullable = false)
    private java.sql.Timestamp lastLoginDatetime;

}
