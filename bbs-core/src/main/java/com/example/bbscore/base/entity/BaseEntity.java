package com.example.bbscore.base.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    public Long registeredUserNumber;
    public Date registeredDatetime;
    public Long lastUpdatedUserNumber;
    public Date lastUpdatedDatetime;
}
