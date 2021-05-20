package com.codezealer.zmall.cart.service;

import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

    Boolean addShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO);
}
