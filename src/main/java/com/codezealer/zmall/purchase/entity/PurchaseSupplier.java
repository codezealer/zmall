package com.codezealer.zmall.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 采购中心的供应商表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseSupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 联系人
     */
    private String contactor;

    /**
     * 联系电话
     */
    private String contactPhoneNumber;

    /**
     * 账期，1：周结算，2：月结算，3：季度结算
     */
    private Integer accountPeriod;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行账户
     */
    private String bankAccount;

    /**
     * 开户人
     */
    private String accountHolder;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 纳税人识别号
     */
    private String taxpayerId;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 说明备注
     */
    private String supplierComment;

    /**
     * 企业资质
     */
    private String enterpriseQualification;

    /**
     * 合作合同
     */
    private Blob cooperateContract;

    /**
     * 协议价合同
     */
    private Blob priceContract;

    /**
     * 采购合同
     */
    private Blob purchaseContract;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
