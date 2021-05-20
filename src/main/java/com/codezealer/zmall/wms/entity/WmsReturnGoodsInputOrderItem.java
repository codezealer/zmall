package com.codezealer.zmall.wms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 退货入库单条目
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WmsReturnGoodsInputOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 退货入库单ID
     */
    private Long returnGoodsInputOrderId;

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 商品sku编号
     */
    private String goodsSkuCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 销售属性，机身颜色:白色,内存容量:256G
     */
    private String saleProperties;

    /**
     * 商品毛重
     */
    private BigDecimal goodsGrossWeight;

    /**
     * 购买数量
     */
    private Long purchaseQuantity;

    /**
     * 商品购买价格
     */
    private BigDecimal purchasePrice;

    /**
     * 促销活动ID
     */
    private Long promotionActivityId;

    /**
     * 商品长度
     */
    private BigDecimal goodsLength;

    /**
     * 商品宽度
     */
    private BigDecimal goodsWidth;

    /**
     * 商品高度
     */
    private BigDecimal goodsHeight;

    /**
     * 合格商品数量
     */
    private Long qualifiedCount;

    /**
     * 商品到货数量
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
