package com.codezealer.zmall.cart.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.cart.dao.ShoppingCartDAO;
import com.codezealer.zmall.cart.entity.ShoppingCart;
import com.codezealer.zmall.cart.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    @Resource
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public ShoppingCart getShoppingCart(Long id) {
        return shoppingCartMapper.selectById(id);
    }

    @Override
    public Long addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartMapper.insert(shoppingCart);
        return shoppingCart.getId();
    }

    @Override
    public ShoppingCart getShoppingCartByAccountId(Long accountId) {
        return shoppingCartMapper.selectOne(new LambdaQueryWrapper<ShoppingCart>().eq(ShoppingCart::getUserAccountId, accountId));
    }

}
