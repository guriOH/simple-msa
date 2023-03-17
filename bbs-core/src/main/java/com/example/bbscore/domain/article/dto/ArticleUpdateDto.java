package com.example.bbscore.domain.article.dto;


import com.example.bbscore.base.dto.BaseInsertDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ArticleUpdateDto extends BaseInsertDto {

    public Long boardId;
    public Long articleId;
    public String articleTitle;
    public String articleContents;
    public String articleCategory;
    public Boolean isPublic;

}
