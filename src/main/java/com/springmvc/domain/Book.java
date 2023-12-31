package com.springmvc.domain;

import com.springmvc.validator.BookId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Getter
@Setter
//@AllArgsConstructor // 파라미터가 들어가는 생성자
@NoArgsConstructor  // 일반 생성자

public class Book {
    @BookId
    @Pattern(regexp="ISBN[1-9]+", message = "{Pattern.NewBook.bookId}")       // 1부터 9 까지 연속된 숫자가 오는 정규 표현식 패턴
    private String bookId;            // 도서Id
    @Size(min=4, max=50, message = "{Size.NewBook.name}")            // 최소 4자 이상, 최대 50자 이하.
    private String name;              // 도서명
    @Min(value=0, message = "{Min.NewBook.unitPrice}")
    @Digits(integer=8,fraction = 2, message = "{Digits.NewBook.unitPrice}")
    @NotNull
    private int unitPrice;            // 도서 가격
    private String author;            // 저자
    private String description;       // 설명
    private String publisher;         // 출판사
    private String category;          //분류
    private long unitsInStock;        // 재고
    private String releaseDate;       // 출판일(월/년)
    private String condition;         // 신규 도서 또는 중고 도서 또는 전자책
    private MultipartFile bookImage;  // 도서 이미지


    public Book(String bookId, String name, int unitPrice) {
        super();
        this.bookId = bookId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

}
