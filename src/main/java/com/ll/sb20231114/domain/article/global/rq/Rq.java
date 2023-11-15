package com.ll.sb20231114.domain.article.global.rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse res;

    public Rq(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }
}
