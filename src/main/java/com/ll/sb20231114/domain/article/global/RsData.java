package com.ll.sb20231114.domain.article.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {     // API 응답을 나타내는 제네릭 클래스
    private String resultCode;
    private String msg;
    private T data;     // data의 타입을 지정하지 않아, 유연하게 값을 받을 수 있다.
}