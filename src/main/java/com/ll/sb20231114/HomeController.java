package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")  // http://localhost:8020/
    @ResponseBody   // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain() {
        System.out.println("안녕하세요!!!");   // 이 메세지는 고객에게 안간다
        return "안녕하세요.";
    }

    @GetMapping("/about")  // http://localhost:8020/
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")   // http://localhost:8020/calc?a=1&b=2
    @ResponseBody
    String showCalc(int a, int b) {
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc2")   // http://localhost:8020/calc2?a=1&b=2
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "a : " + a + ", b : " + b;
    }

    @GetMapping("/calc3")    // http://localhost:8020/calc3?a=2.5&b=3
    @ResponseBody
    String showCalc3(@RequestParam(defaultValue = "0") int a,
                     @RequestParam(defaultValue = "0") int b) {
        return "a : " + a + ", b : " + b;
    }

    @GetMapping("/calc4")    // http://localhost:8020/calc4?a=2.5&b=3
    @ResponseBody
    String showCalc4(@RequestParam(defaultValue = "0") double a,
                     @RequestParam(defaultValue = "0") double b) {
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")    // http://localhost:8020/calc5
    @ResponseBody
    String showCalc5(@RequestParam(defaultValue = "-") String a,
                     @RequestParam(defaultValue = "-") String b) {
        return "계산 결과 : %s".formatted(a + b);
    }

    @GetMapping("/calc6")    // http://localhost:8020/calc6?a=5&b=6
    @ResponseBody
    int showCalc6(int a, int b) {
        return a + b;
    }

    @GetMapping("/calc7")    // http://localhost:8020/calc7?a=5&b=10
    @ResponseBody
    boolean showCalc7(int a, int b) {
        return a > b;
    }

    @GetMapping("/calc8")    // http://localhost:8020/calc8?name=홍길동&age=20
    @ResponseBody
    Person showCalc8(String name, int age) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")    //  http://localhost:8020/calc9?name=홍길동&age=20
    @ResponseBody
    Person2 showCalc9(String name, int age
    ) {
        return new Person2(name, age);
    }

    @GetMapping("/calc10")    // http://localhost:8020/calc8?name=홍길동&age=20
    @ResponseBody
    Map<String, Object> showCalc10(String name, int age) {
        Map<String, Object> personMap = Map.of(    // 출력 순서는 랜덤
                "name", name,
                "age", age
        );

        return personMap;
    }

    @GetMapping("/calc11")    // http://localhost:8020/calc11
    @ResponseBody
    List<Integer> showCalc11() {
        List<Integer> nums = new ArrayList<>() {{
            add(10);
            add(100);
        }};

        return nums;
    }

    @GetMapping("/calc12")    // http://localhost:8020/calc12
    @ResponseBody
    int[] showCalc12() {
        int[] nums = new int[]{10, 100, 500};

        return nums;
    }

    @GetMapping("/calc13")    // http://localhost:8020/calc13?name=홍길동&age=20
    @ResponseBody
    List<Person2> showCalc13(String name, int age) {
        List<Person2> persons = new ArrayList<>() {{    // 익명클래스 이용
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));

        }};

        return persons;
    }

    @AllArgsConstructor
    class Person {
        public String name;
        public int age;
    }

    @AllArgsConstructor
    class Person2 {
        @Getter
        private String name;
        @Getter
        private int age;
    }
}
