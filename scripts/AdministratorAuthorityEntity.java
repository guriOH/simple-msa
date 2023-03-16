package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "administrator_authority", schema = "", catalog = "")
public class AdministratorAuthorityEntity {

    @Basic
    @Column(name = "authority_type", nullable = false)
    private String authorityType;
    @Basic
    @Column(name = "registered_admin_number", nullable = false)
    private long registeredAdminNumber;
    @Basic
    @Column(name = "registered_datetime", nullable = false)
    private java.sql.Timestamp registeredDatetime;
    @Basic
    @Column(name = "administrator_number", nullable = false)
    private long administratorNumber;
    @Basic
    @Column(name = "authority_key", nullable = false)
    private String authorityKey;

}
