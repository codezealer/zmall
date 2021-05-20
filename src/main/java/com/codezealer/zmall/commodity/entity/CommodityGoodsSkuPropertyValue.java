package com.codezealer.zmall.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sku商品对每个销售属性的一个实际值
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityGoodsSkuPropertyValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku ID
     */
    private Long goodsSkuId;

    /**
     * 类目与属性关联关系的ID
     */
    private Long categoryPropertyRelationshipId;

    /**
     * sku对应的某个销售属性的实际值
     */
    private String propertyValue;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
