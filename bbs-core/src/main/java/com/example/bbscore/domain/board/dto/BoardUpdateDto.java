package com.example.bbscore.domain.board.dto;


import com.example.bbscore.base.dto.BaseInsertDto;
import com.example.bbscore.base.dto.BaseUpdateDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardUpdateDto extends BaseUpdateDto {

    public Long boardId;
    public String name;
    public Boolean isAllowedComment;
    public Boolean isAllowedAttach;
}
