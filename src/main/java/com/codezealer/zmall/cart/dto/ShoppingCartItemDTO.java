package com.codezealer.zmall.cart.dto;

import com.codezealer.zmall.promotion.entity.PromotionActivity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShoppingCartItemDTO {
    /**
     * 会员账号ID
     */
    private Long userAccountId;

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 购买数量
     */
    private Long purchaseQuantity;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 销售库存
     */
    private Long saleStockQuantity;

    /**
     * 促销活动
     */
    List<PromotionActivity> promotionActivityList;
}
