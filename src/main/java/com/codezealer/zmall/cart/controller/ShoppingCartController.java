package com.codezealer.zmall.cart.controller;


import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.service.ShoppingCartService;
import com.codezealer.zmall.common.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Resource
    ShoppingCartService shoppingCartService;

    @PostMapping("/addItem")
    public HttpResult<Boolean> addShoppingCartItem(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO) {
        return HttpResult.ok(shoppingCartService.addShoppingCartItem(shoppingCartItemDTO));
    }
}

