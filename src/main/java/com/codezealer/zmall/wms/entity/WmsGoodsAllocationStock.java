package com.codezealer.zmall.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 仓库中的货位库存
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WmsGoodsAllocationStock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 货位ID
     */
    private Long goodsAllocationId;

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 可用库存数量
     */
    private Long availableStockQuantity;

    /**
     * 锁定库存数量
     */
    private Long lockedStockQuantity;

    /**
     * 已出库库存数量
     */
    private Long deliveriedStockQuantity;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
