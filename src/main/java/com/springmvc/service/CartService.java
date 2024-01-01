package com.springmvc.service;

import com.springmvc.domain.Cart;

public interface CartService {

    Cart creat(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
