package com.ll.sb20231114.domain.article.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor   // 이것에 의해 final이 붙은 resultCode, msg를 받는 생성자가 만들어짐
@Getter
public class RsData<T> {     // API 응답을 나타내는 제네릭 클래스
    private final String resultCode;
    private final String msg;
    private T data;     // data의 타입을 지정하지 않아, 유연하게 값을 받을 수 있다.
}