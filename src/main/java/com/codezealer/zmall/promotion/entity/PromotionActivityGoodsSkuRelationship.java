package com.codezealer.zmall.promotion.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 促销活动跟商品sku的关联关系
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PromotionActivityGoodsSkuRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 促销活动ID
     */
    private Long promotionActivityId;

    /**
     * 关联的某个商品sku的ID，如果将这个字段的值设置为-1，那么代表针对全部商品
     */
    private Long goodsId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
