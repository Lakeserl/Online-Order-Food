package com.FoorOrdering.service;

import com.FoorOrdering.model.Cart.Cart;
import com.FoorOrdering.model.Cart.CartItem;
import com.FoorOrdering.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt)throws Exception;

    public Long calculateCartTotal(Cart cart) throws Exception;

    public Cart findCartById(Long id) throws Exception;

    public Cart findCartByUserId(Long userId) throws Exception;

    public Cart cleatCartByUserId(Long userId) throws Exception;
}
