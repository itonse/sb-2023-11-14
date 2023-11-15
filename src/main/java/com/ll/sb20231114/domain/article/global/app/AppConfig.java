package com.ll.sb20231114.domain.article.global.app;

import com.ll.sb20231114.domain.article.article.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    /*
    수 많은 Bean 중 이 것이 ArticleRepository 에 주입되는 이유
    1. 타입 매칭: List<Article> 타입이 정확히 매칭됩니다.
    2. 빈 이름의 중복 없음: 이름이 'articles'인 Bean 은 이 메서드가 유일합니다.
     */
    @Bean
    List<Article> articles() {
        return new java.util.LinkedList<>();
    }
}
