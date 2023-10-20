package com.first.firstone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.firstone.domain.Article;
import com.first.firstone.dto.AddArticleRequest;
import com.first.firstone.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController //http Response body data를 json으로 반환 할 수 있는 컨트롤러

public class BlogApiController {


    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

}
