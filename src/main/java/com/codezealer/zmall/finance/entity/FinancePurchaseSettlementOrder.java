package com.codezealer.zmall.finance.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 财务中心的采购结算单
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FinancePurchaseSettlementOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 预计到货时间
     */
    private LocalDateTime expectArrivalTime;

    /**
     * 实际到货时间
     */
    private LocalDateTime arrivalTime;

    /**
     * 采购联系人
     */
    private String purchaseContactor;

    /**
     * 采购联系电话
     */
    private String purchaseContactPhoneNumber;

    /**
     * 采购联系邮箱
     */
    private String purchaseContactEmail;

    /**
     * 采购入库单的说明备注
     */
    private String purchaseWarehouseEntryOrderComment;

    /**
     * 采购员
     */
    private String purchaser;

    /**
     * 采购入库单状态，1：编辑中，2：待审核，3：已完成
     */
    private Integer purchaseSettlementOrderStatus;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 总结算金额，每个采购商品的价格 * 实际到货数量
     */
    private BigDecimal totalSettlementAmount;


}
