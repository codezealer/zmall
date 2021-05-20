package com.codezealer.zmall.purchase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 采购中心的采购单
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrder implements Serializable {

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
     * 联系人
     */
    private String contactor;

    /**
     * 联系电话
     */
    private String contactPhoneNumber;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 说明备注
     */
    private String purchaseOrderComment;

    /**
     * 采购员
     */
    private String purchaser;

    /**
     * 采购单状态，1：编辑中，2：待审核，3：已审核，4：待入库，5：待结算，6：已完成
     */
    private Integer purchaseOrderStatus;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
