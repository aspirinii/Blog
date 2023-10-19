package com.first.firstone.service;
import org.springframework.stereotype.Service; // 맞나?

import com.first.firstone.domain.Article;
import com.first.firstone.dto.AddArticleRequest;
import com.first.firstone.repository.BlogRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 또는 @NotNull 인 필드 값만 파라미터로 받는 생성자를 만들어줌
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 게시글 추가 메서드
    public Article save(AddArticleRequest request) {
        Article article = request.toEntity();
        return blogRepository.save(article);
    }
}
