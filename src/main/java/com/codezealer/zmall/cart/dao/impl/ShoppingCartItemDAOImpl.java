package com.codezealer.zmall.cart.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    @Override
    public Boolean updatePurchaseQuantity(Long id, Long purchaseQuantity) {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setPurchaseQuantity(purchaseQuantity);
        int count = shoppingCartItemMapper.update(shoppingCartItem, new LambdaUpdateWrapper<ShoppingCartItem>().eq(ShoppingCartItem::getId, id));
        return count > 0 ? true : false;
    }

    @Override
    public boolean delete(Long id) {
        return shoppingCartItemMapper.deleteById(id) > 0 ? true : false;
    }

    @Override
    public ShoppingCartItem getShoppingCartItemByGoodsSkuId(Long shoppingCartId, Long goodsSkuId) {
        return shoppingCartItemMapper.selectOne(new LambdaQueryWrapper<ShoppingCartItem>()
                                            .eq(ShoppingCartItem::getShoppingCartId, shoppingCartId)
                                            .eq(ShoppingCartItem::getGoodsSkuId, goodsSkuId));
    }

    @Override
    public void remove(Long id) {
        shoppingCartItemMapper.deleteById(id);
    }
}
