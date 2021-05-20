package com.codezealer.zmall.cart.dao.impl;

import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import com.codezealer.zmall.cart.mapper.ShoppingCartItemMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {

    @Resource
    ShoppingCartItemMapper shoppingCartItemMapper;

    @Override
    public Long save(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemMapper.insert(shoppingCartItem);
        return shoppingCartItem.getId();
    }
}
