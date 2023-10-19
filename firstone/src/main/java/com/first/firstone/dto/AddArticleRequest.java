package com.first.firstone.dto;
import com.first.firstone.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자 추가
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자 추가
@Getter

public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
        .title(title)
        .content(content)
        .build();
    }
}
