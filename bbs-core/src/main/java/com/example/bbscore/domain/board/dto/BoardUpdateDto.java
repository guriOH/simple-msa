package com.example.bbscore.domain.board.dto;


import com.example.bbscore.base.dto.BaseInsertDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardUpdateDto extends BaseInsertDto {

    public String name;
    public Boolean isAllowedComment;
    public Boolean isAllowedAttach;
}
