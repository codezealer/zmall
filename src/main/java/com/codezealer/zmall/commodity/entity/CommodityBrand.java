package com.codezealer.zmall.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品中心的品牌表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 品牌中文名
     */
    private String brandChineseName;

    /**
     * 品牌英文名
     */
    private String brandEnglishName;

    /**
     * 品牌别名
     */
    private String brandAliasName;

    /**
     * logo图片
     */
    private String logoUrl;

    /**
     * 品牌介绍
     */
    private String brandIntro;

    /**
     * 品牌授权凭证
     */
    private String brandAuthorizationVoucherUrl;

    /**
     * 品牌所在地
     */
    private String location;

    /**
     * 品牌说明备注
     */
    private String brandComment;

    /**
     * 是否启用，1：启用，0：未启用
     */
    private Integer isEnabled;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
