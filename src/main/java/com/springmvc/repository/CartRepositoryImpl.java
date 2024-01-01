package com.springmvc.repository;

import com.springmvc.domain.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartRepositoryImpl implements CartRepository {
    private Map<String, Cart> listofCarts;
    public  CartRepositoryImpl(){
        listofCarts = new HashMap<String, Cart>();
    }
    @Override
    public Cart creat(Cart cart) {
        if (listofCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재합니다", cart.getCartId()));
        }
        listofCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listofCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listofCarts.keySet().contains(cartId)) {
            // 장바구니 ID가 존재하지 않은 경우 예외 처리
            throw new IllegalArgumentException(String.format("장바구니 목록을 갱신할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다.", cartId));
        }
        listofCarts.put(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        if (!listofCarts.keySet().contains(cartId)) {
            // 장바구니 ID가 존재하지 않으면 예외 처리
            throw new IllegalArgumentException(String.format("장바구니 목록을 삭제할 수 없습니다. 장바구니 id(%)가 존재하지 않습니다.", cartId));
        }
        listofCarts.remove(cartId);
    }
}
