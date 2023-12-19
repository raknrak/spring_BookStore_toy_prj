package com.springmvc.chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class Example03Controller {
   // 패키지의 위치가 중요한 것이 아니라
   @RequestMapping("/exam03/{bookId}")
   public String requestMethod(@PathVariable String bookId, @MatrixVariable String category, Model model) {
       System.out.println("도서 ID : " + bookId);
       System.out.println("도서 분야 : " + category);
       model.addAttribute("data", "도서 ID : " + bookId +"<br>"+ " 도서 분야 : "+ category);
       return "webpage06";

       //URL : http://localhost:8092/BookMarket/test/exam03/ISBN1234;category=IT전문서
       // Matrix를 사용할 땐 ; 을 사용하여 구분?

   }


}
