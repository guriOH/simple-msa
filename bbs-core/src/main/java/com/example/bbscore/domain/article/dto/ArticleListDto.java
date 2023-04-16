package com.example.bbscore.domain.article.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class ArticleListDto {
    private String boardId;
    private String boardName;

    private List<ArticleDetailDto> articles;


}
