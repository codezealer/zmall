package com.codezealer.zmall.cart.dao;

import com.codezealer.zmall.cart.entity.ShoppingCart;

public interface ShoppingCartDAO {
    ShoppingCart getShoppingCart(Long id);

    Long addShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart getShoppingCartByAccountId(Long accountId);
}
