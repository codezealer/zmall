package com.codezealer.zmall.inventory.dto;

import lombok.Data;

@Data
public class ReturnGoodsInputDTO {

    /**
     * 商品SKU ID
     */
    private Long goodsSkuId;
    /**
     * 退货商品数量
     */
    private Integer returnCount;


}
