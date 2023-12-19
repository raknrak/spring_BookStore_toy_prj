package com.springmvc.chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class Example07Controller {

    @RequestMapping("/exam07")
    public String requestMethod(@RequestParam String id, Model model) {
        System.out.println("도서 ID : " + id);
        model.addAttribute("data", "도서 ID : " + id);

        return "webpage06";

        // URL : http://localhost:8092/BookMarket/test/exam07?id=ISBN1234
    }


}
