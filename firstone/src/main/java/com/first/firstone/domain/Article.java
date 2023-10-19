package com.first.firstone.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor // 기본 생성자
public class Article {
    @Id // pk, 기본키로 지정
    @GeneratedValue // 기본키 1씩 증가
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

    // protected Article() {} // 기본 생성자, 롬복으로 대체

    // //게터, 롬복으로 대체
    // public Long getId() {
    //     return id;
    // }
    // public String getTitle() {
    //     return title;
    // }

    // public String getContent() {
    //     return content;
    // }
}
