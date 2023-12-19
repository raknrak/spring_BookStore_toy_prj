package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
        // url : http://localhost:8092/BookMarket/books/all
    }

    @GetMapping("/{category}") // 경로변수 category(=@RequestMapping("/category")
    // 경로변수 category를 bookCategory로 재정의
    // 데이터를 모델에 저장해서 뿌리므로 모델이 필요함.
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
        //bookCategory와 일치하는 도서 목록을 서비스 객체에서 가져와 booksByCategory에 저장
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        // 키 이름 : 북 리스트 ,
        model.addAttribute("bookList", booksByCategory); // 값을 모델 속성 booklist에 저장 후 출력
        return "books"; // books.jsp
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model){
        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "book"; // book.jsp
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model) {

        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books";
    }

    @GetMapping("/add")
    public String requestAddBookForm(Book book) {
        return "addBook";
    }


}

