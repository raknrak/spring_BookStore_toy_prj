package com.springmvc.service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList(); // 저장된 도서 목록을 가져옴.

    }
    @Override
    public List<Book> getBookListByCategory(String category) {
        // 저장소 객체에서 일치하는 도서 목록을 가져와서 저장
        List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
        return booksByCategory; // 도서목록이 저장된 도서 목록 객체 반환
    }

    @Override
    public Book getBookById(String bookId) {
        Book bookById = bookRepository.getBookById(bookId);
        return bookById;
    }
}
