package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "authority", schema = "", catalog = "")
public class Authority {

    @Basic
    @Column(name = "authority_key", nullable = false)
    private String authorityKey;
    @Basic
    @Column(name = "authority_name", nullable = false)
    private String authorityName;
    @Basic
    @Column(name = "authority_description", nullable = false)
    private String authorityDescription;
    @Basic
    @Column(name = "is_activated", nullable = false)
    private String isActivated;
    @Basic
    @Column(name = "registered_admin_number", nullable = false)
    private long registeredAdminNumber;
    @Basic
    @Column(name = "registered_datetime", nullable = false)
    private java.sql.Timestamp registeredDatetime;

}
