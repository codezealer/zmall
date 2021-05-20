package com.codezealer.zmall.cart.dao;

import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemDAO {
    Long save(ShoppingCartItem shoppingCartItem);

    List<ShoppingCartItem> queryListByShoppingCartId(Long shoppingCartId);
}
