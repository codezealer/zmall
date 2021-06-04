package com.codezealer.zmall.cart.service;

public interface ShoppingCartItemService {
    Boolean updatePurchaseQuantity(Long id, Long purchaseQuantity);

    boolean remove(Long id);
}
