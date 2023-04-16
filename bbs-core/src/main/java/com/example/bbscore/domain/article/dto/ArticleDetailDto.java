package com.example.bbscore.domain.article.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class ArticleDetailDto {
    private String title;
    private String createdBy;
    private Date createdAt;
}
