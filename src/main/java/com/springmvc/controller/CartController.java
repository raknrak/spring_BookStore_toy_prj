package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestCartId(HttpServletRequest request) {
        String sessionid = request.getSession(true).getId();
        return "redirect:/cart/" + sessionid;
    }

    @PostMapping
    public @ResponseBody Cart creat(@RequestBody Cart cart) {
        return cartService.creat(cart);
    }

    @GetMapping("{cartId}")
    public String requestCartList(@PathVariable("cartId") String cartId, Model model) {
        Cart cart = cartService.read(cartId);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PutMapping("{cartId}")
    public @ResponseBody Cart read(@PathVariable("cartId") String cartId) {
        return cartService.read(cartId);
    }

    @PutMapping("/add/{bookId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT) //오류 응답 상태 코드 설정
    public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request) {
        // 장바구니 ID인 sessionid 가져오기
        String sessionid = request.getSession(true).getId();
        Cart cart = cartService.read(sessionid); // 장바구니에 등록된 모든 정보 얻어 오기
        if (cart == null)
            cart = cartService.creat(new Cart(sessionid));
        Book book = bookService.getBookById(bookId);
        if (book == null)
            throw new IllegalArgumentException(new BookIdException(bookId));
        // bookId에 대한 도서 정보를 장바구니에 등록하기
        cart.addCartItem(new CartItem(book));
        cartService.update(sessionid, cart); // sessionid에 대한 장바구니 갱신하기.
    }

    @PutMapping("/remove/{bookId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable String bookId, HttpServletRequest request) {
        // 장바구니 ID인 sessionid 가져오기
        String sessionid = request.getSession(true).getId();
        Cart cart = cartService.read(sessionid); // 장바구니에 등록된 보든 정보 얻어오기
        if (cart == null)
            cart = cartService.creat(new Cart(sessionid));
        Book book = bookService.getBookById(bookId);
        if (book == null)
            throw new IllegalArgumentException(new BookIdException(bookId));
        // bookId에 대한 도서 정보를 장바구니에서 삭제하기
        cart.removeCartItem(new CartItem(book));
        cartService.update(sessionid, cart); // sessionid에 대한 장바구니 갱신하기.
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCartList(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }
}

