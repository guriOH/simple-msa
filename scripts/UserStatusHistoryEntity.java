package com.sample;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user_status_history", schema = "", catalog = "")
public class UserStatusHistoryEntity {

    @Basic
    @Column(name = "user_status_history_id", nullable = false)
    private long userStatusHistoryId;
    @Basic
    @Column(name = "user_number", nullable = false)
    private long userNumber;
    @Basic
    @Column(name = "user_status", nullable = false)
    private String userStatus;
    @Basic
    @Column(name = "change_reason", nullable = false)
    private String changeReason;
    @Basic
    @Column(name = "registered_datetime", nullable = false)
    private java.sql.Timestamp registeredDatetime;

}
