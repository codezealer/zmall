package com.codezealer.zmall.inventory.dto;

import lombok.Data;

@Data
public class PurchaseInputOrderItemDTO {

    /**
     * 商品SKU ID
     */
    private Long goodsSkuId;

    /**
     * 采购数量
     */
    private Long purchaseCount;

    /**
     * 采购价格
     */
    private Long purchasePrice;

}
