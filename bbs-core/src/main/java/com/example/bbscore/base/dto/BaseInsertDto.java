package com.example.bbscore.base.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class BaseInsertDto {

    public Long registeredUserNumber;
    public Date registeredDatetime;


    public Date getRegisteredDatetime() {
        return new Date();
    }
}
