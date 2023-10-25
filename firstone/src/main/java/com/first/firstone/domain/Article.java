package com.first.firstone.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED) // 기본 생성자
public class Article {
    @Id // pk, 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 1씩 증가 // data sql 문제 원인 
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 이라는 컬럼과 매핑, null 허용 안함
    private String title;

    @Column(name = "content", nullable = true)
    private String content;

    @Builder //외부에서 생성시 빌더패턴을 사용할수 있게 해줌, 생성자 대신 사용, 롬복 지원 어노테이션
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
