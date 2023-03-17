package com.example.bbscore.domain.board.dto;


import com.example.bbscore.base.dto.BaseInsertDto;
import lombok.*;

@Setter
@Getter
@ToString
public class BoardInsertDto extends BaseInsertDto {

    public String name;
    public Boolean isAllowedComment;
    public Boolean isAllowedAttach;
}
