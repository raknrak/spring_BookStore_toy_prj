package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestBookList(Model model){
        List<Book> list = bookService.getAllBookList(); // 웹 요청을 처리할 메서드
        model.addAttribute("bookList", list); // 모델 속성 bookList에 저장된 도서 목록을 저장
        return "books"; // book을 반환하므로 book.jsp가 있어야함.

    }

    /*@RequestMapping(value="/all")
    public String requestAllBookList(Model model){
        List<Book> list = bookService.getAllBookList(); // 웹 요청을 처리할 메서드
        model.addAttribute("bookList", list); // 모델 속성 bookList에 저장된 도서 목록을 저장
        return "books"; // book을 반환하므로 book.jsp가 있어야함.

    }*/
    @GetMapping("/all")
    public ModelAndView requestAllBookList( ){
        ModelAndView modelAndView = new ModelAndView();

        List<Book> list = bookService.getAllBookList(); // 웹 요청을 처리할 메서드
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");
        return modelAndView; // book을 반환하므로 book.jsp가 있어야함.

    }
}
// url : http://localhost:8092/BookMarket/books/all