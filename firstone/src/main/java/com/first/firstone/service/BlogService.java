package com.first.firstone.service;
import java.util.List;

import org.springframework.stereotype.Service; // 맞나?

import com.first.firstone.domain.Article;
import com.first.firstone.dto.AddArticleRequest;
import com.first.firstone.dto.UpdateArticleRequest;
import com.first.firstone.repository.BlogRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 또는 @NotNull 인 필드 값만 파라미터로 받는 생성자를 만들어줌
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional // 중요 작업시 하나가 실패하면 모두 실패하게 하는 어노테이션
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
