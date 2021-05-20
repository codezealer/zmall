package com.codezealer.zmall.commodity.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品中心的商品信息基础表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityGoods implements Serializable {

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
     * 品牌ID
     */
    private Long brandId;

    /**
     * SPU编号
     */
    private String spuCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品副名称
     */
    private String goodsSubName;

    /**
     * 商品毛重，单位是g
     */
    private BigDecimal grossWeight;

    /**
     * 外包装长度，单位是cm
     */
    private BigDecimal goodsLength;

    /**
     * 外包装宽，单位是cm
     */
    private BigDecimal goodsWidth;

    /**
     * 外包装高，单位是cm
     */
    private BigDecimal goodsHeight;

    /**
     * 商品状态，1：待审核，2：待上架，3：审核未通过，4：已上架
     */
    private Integer goodsStatus;

    /**
     * 服务保证
     */
    private String serviceGuarantees;

    /**
     * 包装清单
     */
    private String packageList;

    /**
     * 运费模板ID
     */
    private Long freightTemplateId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
