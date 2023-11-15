package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.global.RsData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write(
            String title,
            String body
    ) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        return new RsData<>(     // <> 안에 타입 생략 가능
                "S-1",    // 성공 코드
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),   // 성공 메시지
                article    // 작성된 게시물 객체
        );
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles.getLast();    // 리스트의 마지막 원소 가져오기
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }
}
