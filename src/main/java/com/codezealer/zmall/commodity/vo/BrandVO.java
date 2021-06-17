package com.codezealer.zmall.commodity.vo;

import lombok.Data;

import java.sql.Blob;

@Data
public class BrandVO {
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
}
