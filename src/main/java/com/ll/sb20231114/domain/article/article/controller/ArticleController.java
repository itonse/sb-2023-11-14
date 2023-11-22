package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.domain.article.global.rq.Rq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    String write(@Valid WriteForm writeForm) {
        Article article = articleService.write(writeForm.title, writeForm.body);

        String msg = "id %d, article created".formatted(article.getId());

        return "redirect:/article/list?msg=" + msg;
    }

    @GetMapping("/article/list")
    String showList(Model model) {    //  model은 Spring MVC에서 뷰에 데이터를 전달하는 데 사용되는 객체
        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);   // model에 articles 라는 이름으로 데이터를 추가하여 뷰로 전달

        return "article/list";   // 페이지(뷰) 반환
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

    @GetMapping("/article/rqTest")    // Rq도 @RequestScope에 의해 요청이 들어오면 객체가 생성되고, 끝나면 사라진다
    @ResponseBody
    String rqPointer() {
        return rq.toString();
    }
}
