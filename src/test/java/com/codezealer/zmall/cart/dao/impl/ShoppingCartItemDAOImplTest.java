package com.codezealer.zmall.cart.dao.impl;

import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartItemDAOImplTest {

    @Resource
    ShoppingCartItemDAO shoppingCartItemDAO;

    @Test
    public void save() {
        Long shoppingCartId = 2L;
        Long goodsSkuId = 1L;
        Long purchaseQuantity = 1L;

        ShoppingCartItem shoppingCartItemDO = createShoppingCartItem(
                shoppingCartId, goodsSkuId, purchaseQuantity);
        Long shoppingCartItemId = shoppingCartItemDO.getId();

        assertNotNull(shoppingCartItemId);
    }

    @Test
    public void queryListByShoppingCartId() {
    }

    @Test
    public void updatePurchaseQuantity() {
    }

    @Test
    public void delete() {
    }

    private ShoppingCartItem createShoppingCartItem(Long shoppingCartId,
                                                    Long goodsSkuId, Long purchaseQuantity) {
        ShoppingCartItem item = shoppingCartItemDAO.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);

        if(item != null) {
            shoppingCartItemDAO.remove(item.getId());
        }

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setShoppingCartId(shoppingCartId);
        shoppingCartItem.setGoodsSkuId(goodsSkuId);
        shoppingCartItem.setPurchaseQuantity(purchaseQuantity);
        shoppingCartItem.setGmtCreate(LocalDateTime.now());
        shoppingCartItem.setGmtModified(LocalDateTime.now());

        shoppingCartItemDAO.save(shoppingCartItem);
        return shoppingCartItem;
    }
}