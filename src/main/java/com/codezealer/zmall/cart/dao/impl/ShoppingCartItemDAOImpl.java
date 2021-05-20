package com.codezealer.zmall.cart.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import com.codezealer.zmall.cart.mapper.ShoppingCartItemMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {

    @Resource
    ShoppingCartItemMapper shoppingCartItemMapper;

    @Override
    public Long save(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemMapper.insert(shoppingCartItem);
        return shoppingCartItem.getId();
    }

    @Override
    public List<ShoppingCartItem> queryListByShoppingCartId(Long shoppingCartId) {
        return shoppingCartItemMapper.selectList(new LambdaQueryWrapper<ShoppingCartItem>().eq(ShoppingCartItem::getShoppingCartId, shoppingCartId));
    }
}
