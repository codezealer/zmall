package com.codezealer.zmall.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品中心的类目和属性的关联关系表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityCategoryPropertyRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类目ID
     */
    private Long categoryId;

    /**
     * 属性ID
     */
    private Long propertyId;

    /**
     * 属性是否必填，1：是必填，0：非必填
     */
    private Integer isRequired;

    /**
     * 属性类型，1：关键属性，2：销售属性，3：非关键属性，4：导购属性，这里可以有多个值拼接在一起，比如1,2，2,4
     */
    private Integer propertyType;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
