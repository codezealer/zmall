package com.codezealer.zmall.pay.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 支付交易流水
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 交易流水号，第三方支付平台生成
     */
    private String transactionNumber;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单总金额
     */
    private BigDecimal totalOrderAmount;

    /**
     * 订单优惠金额
     */
    private BigDecimal discountOrderAmount;

    /**
     * 订单应付金额
     */
    private BigDecimal payableOrderAmount;

    /**
     * 交易渠道，1：支付宝，2：微信
     */
    private Integer transactionChannel;

    /**
     * 交易渠道账户
     */
    private String transactionChannelAccount;

    /**
     * 第三方平台完成支付的时间
     */
    private LocalDateTime transactionChannelPayTime;

    /**
     * 交易渠道返回的支付订单号
     */
    private String transactionChannelOrderNo;

    /**
     * 交易渠道返回的状态码
     */
    private String transactionChannelStatus;

    /**
     * 用户账号ID
     */
    private Long userAccountId;

    /**
     * 用户支付账号
     */
    private String userPayAccount;

    /**
     * 支付状态
     */
    private String transactionStatus;


}
