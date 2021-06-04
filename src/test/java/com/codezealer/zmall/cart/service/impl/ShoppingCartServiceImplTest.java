package com.codezealer.zmall.cart.service.impl;

import static org.mockito.Mockito.*;

import com.codezealer.zmall.cart.dao.ShoppingCartDAO;
import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.entity.ShoppingCart;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import com.codezealer.zmall.cart.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceImplTest {

    @Resource
    ShoppingCartService shoppingCartService;

    @MockBean
    ShoppingCartDAO shoppingCartDAO;

    @MockBean
    ShoppingCartItemDAO shoppingCartItemDAO;

    @Test
    public void addShoppingCartItem() {
        Long userAccountId = 1L;
        Long goodsSkuId = 1L;
        ShoppingCart shoppingCart = createShoppingCartDO(userAccountId);
        ShoppingCartItem shoppingCartItem = createShoppingCartItemDO(shoppingCart.getId(), goodsSkuId);
        //mock一下两个dao的行为
        when(shoppingCartDAO.getShoppingCartByAccountId(userAccountId)).thenReturn(shoppingCart);

        shoppingCartItem.setPurchaseQuantity(shoppingCartItem.getPurchaseQuantity() + 1L);
        ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();

    }

    @Test
    public void getShoppingCart() {
    }

    private ShoppingCart createShoppingCartDO(Long userAccountId) {
        Long id = 1L;

        ShoppingCart shoppingCartDO = new ShoppingCart();
        shoppingCartDO.setId(id);
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(LocalDateTime.now());
        shoppingCartDO.setGmtModified(LocalDateTime.now());

        return shoppingCartDO;
    }

    private ShoppingCartItem createShoppingCartItemDO(Long shoppingCartId, Long goodsSkuId) {
        Long id = 1L;
        Long purchaseQuantity = 1L;

        ShoppingCartItem shoppingCartItemDO = new ShoppingCartItem();
        shoppingCartItemDO.setId(id);
        shoppingCartItemDO.setShoppingCartId(shoppingCartId);
        shoppingCartItemDO.setGoodsSkuId(goodsSkuId);
        shoppingCartItemDO.setPurchaseQuantity(purchaseQuantity);
        shoppingCartItemDO.setGmtCreate(LocalDateTime.now());
        shoppingCartItemDO.setGmtModified(LocalDateTime.now());

        return shoppingCartItemDO;
    }
}