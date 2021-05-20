package com.codezealer.zmall.cart.dto;

import lombok.Data;

@Data
public class ShoppingCartItemDTO {

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 购买数量
     */
    private Long purchaseQuantity;
    /**
     * 会员账号ID
     */
    private Long userAccountId;

}
