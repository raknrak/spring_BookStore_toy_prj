package com.springmvc.chap07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Example03Controller {
    @GetMapping("/exam03")
    public String showForm() {
        return "webpage07_03";

    }

    @ModelAttribute("title")
    public String setTitle() {
        return "@ModelAttribute 유형";

    }
    @ModelAttribute
    public void setSubTitle(Model model) {
        model.addAttribute("subtitle", "메소드에 @ModelAttribute 애너테이션 적용");

    }
}
