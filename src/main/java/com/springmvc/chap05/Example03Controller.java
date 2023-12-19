package com.springmvc.chap05;

import org.springframework.web.bind.annotation.RequestMapping;

 // @Controller("/chap05") 사용하지 않는 컨트롤러는 주석처리 후 컨테이너에서 제외하기
@RequestMapping("/chap05")
public class Example03Controller {
    // 패키지의 위치가 중요한 것이 아니라
    @RequestMapping("/exam03")
    public void requestMethod() {
        System.out.println("@RequestMapping 예제입니다.");
        System.out.println("엡 요청 URL은 /home/exam03입니다.");

        //URL : http://localhost:8092/BookMarket/chap05/exam03
    }


}
