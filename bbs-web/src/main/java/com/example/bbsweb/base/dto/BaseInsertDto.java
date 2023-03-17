package com.example.bbsweb.base.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseInsertDto {

    public Long registeredUserNumber;
    public Date registeredDatetime;
}
