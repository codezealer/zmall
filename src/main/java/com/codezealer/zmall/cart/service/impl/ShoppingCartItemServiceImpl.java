package com.codezealer.zmall.cart.service.impl;

import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import com.codezealer.zmall.cart.mapper.ShoppingCartItemMapper;
import com.codezealer.zmall.cart.service.ShoppingCartItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车的商品条目 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class ShoppingCartItemServiceImpl extends ServiceImpl<ShoppingCartItemMapper, ShoppingCartItem> implements ShoppingCartItemService {

}
