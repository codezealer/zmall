package com.codezealer.zmall.inventory.dto;

import lombok.Data;

import java.util.Date;

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
    private Double purchasePrice;
    /**
     * 商品sku到货后质检出来的合格商品数量
     */
    private Long qualifiedCount;
    /**
     * 商品sku实际到货的数量
     */
    private Long arrivalCount;
    /**
     * 采购入库单条目的创建时间
     */
    private Date gmtCreate;
    /**
     * 采购入库单条目的修改时间
     */
    private Date gmtModified;
}
