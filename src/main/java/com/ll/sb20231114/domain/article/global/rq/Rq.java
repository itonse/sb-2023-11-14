package com.ll.sb20231114.domain.article.global.rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/* @RequestScope
   객체의 생명주기 설정 (HTTP 요청마다 객체의 인스턴스가 새롭게 생성되고, 끝날 때 제거된다)
   보유 필드 중 가장 짧은 수명에 맞춘다.
 */
@RequestScope
@Component
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse res;

    public Rq(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }
}
