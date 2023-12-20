package com.springmvc.chap07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Example02Controller {
    @PostMapping("/member")
    public String submitForm(@ModelAttribute Member member, Model model) {
        //Member member = new Member();
        System.out.println("@PostMapping-----------");
        System.out.println("아이디: " + member.getId());
        System.out.println("비밀번호: "+ member.getPassword());
        System.out.println("거주지: " + member.getCity());
        System.out.println("성별: "+ member.getSex());
        System.out.print("취미: ");
        for (int i = 0; i < member.getHobby().length; i++) {
            System.out.println("["+member.getHobby()[i]+"]");
        }
        model.addAttribute("member", member);
        return "webpage07_02";

    }
}
