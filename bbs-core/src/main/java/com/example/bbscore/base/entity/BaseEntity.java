package com.example.bbscore.base.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
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
