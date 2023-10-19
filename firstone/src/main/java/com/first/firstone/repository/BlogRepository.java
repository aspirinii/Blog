package com.first.firstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.first.firstone.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {
    
    
}