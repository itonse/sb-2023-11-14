package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        RsData<Article> rs = new RsData<>(     // <> 안에 타입 명시 필요
                "S-1",    // 성공 코드
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),   // 성공 메시지
                article    // 작성된 게시물 객체
        );

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }
}

@AllArgsConstructor
@Getter
class RsData<T> {     // API 응답을 나타내는 제네릭 클래스
    private String resultCode;
    private String msg;
    private T data;     // data의 타입을 지정하지 않아, 유연하게 값을 받을 수 있다.
}

@AllArgsConstructor
@Getter
class Article {
    private long id;
    private String title;
    private String body;
}
