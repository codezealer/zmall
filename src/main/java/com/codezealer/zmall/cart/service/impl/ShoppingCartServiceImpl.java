package com.codezealer.zmall.cart.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codezealer.zmall.cart.dao.ShoppingCartDAO;
import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.entity.ShoppingCart;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import com.codezealer.zmall.cart.mapper.ShoppingCartMapper;
import com.codezealer.zmall.cart.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

    @Resource
    ShoppingCartDAO shoppingCartDAO;

    @Resource
    ShoppingCartItemDAO shoppingCartITemDAO;


    @Override
    public Boolean addShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO) {
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByAccountId(shoppingCartItemDTO.getUserAccountId());
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserAccountId(shoppingCartItemDTO.getUserAccountId());
            shoppingCart.setGmtCreate(LocalDateTime.now());
            shoppingCart.setGmtModified(LocalDateTime.now());
            shoppingCartDAO.addShoppingCart(shoppingCart);
        }
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        BeanUtil.copyProperties(shoppingCartItemDTO, shoppingCartItem);
        shoppingCartItem.setShoppingCartId(shoppingCart.getId());
        shoppingCartItem.setGmtCreate(LocalDateTime.now());
        shoppingCartItem.setGmtModified(LocalDateTime.now());
        shoppingCartITemDAO.save(shoppingCartItem);
        return true;
    }
}
