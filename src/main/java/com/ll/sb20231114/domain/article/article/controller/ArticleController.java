package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.domain.article.global.rq.Rq;
import com.ll.sb20231114.domain.article.global.rsData.RsData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;   // 대리자

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @Setter
    @Getter
    public static class WriteForm {
        @NotBlank(message = "제목을 입력해주세요.")
        private String title;
        @NotBlank(message = "내용을 입력해주세요.")
        private String body;
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write(
            @Valid WriteForm writeForm
    ) {
        Article article = articleService.write(writeForm.title, writeForm.body);

        return new RsData<>(     // <> 안에 타입 생략 가능
                "S-1",    // 성공 코드
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),   // 성공 메시지
                article    // 작성된 게시물 객체
        );
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articleService.findLastArticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articleService.findAll();
    }

    ///// 객체의 생명주기

    @GetMapping("/article/articleServicePointer")    // 서비스 객체는 처음 생성 후 매번 요청마다 같은 객체를 사용
    @ResponseBody
    String articleServicePointer() {
        return articleService.toString();
    }

    @GetMapping("/article/httpServletRequestPointer")    // Request는 요청이 들어오면 객체가 생성되고, 끝나면 사라진다
    @ResponseBody
    String httpServletRequestPointer(HttpServletRequest req) {
        return req.toString();
    }

    @GetMapping("/article/httpServletResponsePointer")    // Response도 요청이 들어오면 객체가 생성되고, 끝나면 사라진다
    @ResponseBody
    String httpServletResponsePointer(HttpServletResponse resp) {
        return resp.toString();
    }

    @GetMapping("/article/rqPointer")    // Rq도 @RequestScope에 의해 요청이 들어오면 객체가 생성되고, 끝나면 사라진다
    @ResponseBody
    String rqPointer() {
        return rq.toString();
    }
}
