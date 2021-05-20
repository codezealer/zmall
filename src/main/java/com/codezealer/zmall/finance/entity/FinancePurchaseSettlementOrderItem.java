package com.codezealer.zmall.finance.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 财务中心的采购结算单
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FinancePurchaseSettlementOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购结算单ID
     */
    private Long purchaseSettlementOrderId;

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

    /**
     * 合格商品的数量
     */
    private Long qualifiedCount;

    /**
     * 到货的商品数量
     */
    private Long arrivalCount;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
