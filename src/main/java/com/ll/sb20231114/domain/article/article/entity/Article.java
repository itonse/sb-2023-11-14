package com.ll.sb20231114.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Article {
    private Long id;
    private String title;
    private String body;

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
