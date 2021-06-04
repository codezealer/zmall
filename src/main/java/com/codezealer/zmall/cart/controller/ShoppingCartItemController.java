package com.codezealer.zmall.cart.controller;

import com.codezealer.zmall.cart.service.ShoppingCartItemService;
import com.codezealer.zmall.common.http.HttpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cart/item")
public class ShoppingCartItemController {

    @Resource
    ShoppingCartItemService shoppingCartItemService;

    @RequestMapping("/updatePurchaseQuantity")
    public HttpResult<Boolean> updatePurchaseQuantity(@RequestParam("id") Long id, @RequestParam("purchaseQuantity") Long purchaseQuantity) {
        Boolean isSuccess = shoppingCartItemService.updatePurchaseQuantity(id, purchaseQuantity);
        return isSuccess ? HttpResult.ok() : HttpResult.error();
    }

    @RequestMapping("/remove")
    public HttpResult<Boolean> remove(@RequestParam("id") Long id) {
        return shoppingCartItemService.remove(id) ? HttpResult.ok() : HttpResult.error();
    }

}
