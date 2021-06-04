package com.codezealer.zmall.cart.dao.impl;

import cn.hutool.core.date.DateUtil;
import com.codezealer.zmall.cart.dao.ShoppingCartDAO;
import com.codezealer.zmall.cart.entity.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional(rollbackFor = Exception.class)
//@Rollback(true)
public class ShoppingCartDAOImplTest {

    @Resource
    ShoppingCartDAO shoppingCartDAO;

    @Test
    public void testGetShoppingCart() {
        Long id = 2L;
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(id);
        assertEquals(shoppingCart.getId(), id);
    }

    @Test
    public void testAddShoppingCart() {

        Long accountId = 1L;
        ShoppingCart shoppingCart = createShoppingCart(accountId);
        Long shoppingCartId = shoppingCart.getId();

        assertNotNull(shoppingCartId);

    }

    @Test
    public void testGetShoppingCartByAccountId() {
        Long accountId = 1L;
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByAccountId(accountId);
        assertEquals(shoppingCart.getUserAccountId(), accountId);

    }

    private ShoppingCart createShoppingCart(Long userAccountId) {
        ShoppingCart shoppingCartDO = new ShoppingCart();
        shoppingCartDO.setUserAccountId(userAccountId);
        shoppingCartDO.setGmtCreate(LocalDateTime.now());
        shoppingCartDO.setGmtModified(LocalDateTime.now());

        shoppingCartDAO.addShoppingCart(shoppingCartDO);

        return shoppingCartDO;
    }
}