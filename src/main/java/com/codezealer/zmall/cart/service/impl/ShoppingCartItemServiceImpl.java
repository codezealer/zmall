package com.codezealer.zmall.cart.service.impl;

import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.service.ShoppingCartItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

    @Resource
    ShoppingCartItemDAO shoppingCartItemDAO;

    @Override
    public Boolean updatePurchaseQuantity(Long id, Long purchaseQuantity) {
        return shoppingCartItemDAO.updatePurchaseQuantity(id, purchaseQuantity);
    }

    @Override
    public boolean remove(Long id) {
        return shoppingCartItemDAO.delete(id);
    }
}
