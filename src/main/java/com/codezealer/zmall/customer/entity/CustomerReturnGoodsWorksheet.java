package com.codezealer.zmall.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客服中心的退货工单
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerReturnGoodsWorksheet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 退货工单状态，1：待审核，2：审核不通过，3：待寄送退货商品，4：退货商品待收货，5：退货待入库，6：退货已入库，7：完成退款
     */
    private Integer returnGoodsWorksheetStatus;

    /**
     * 退货原因，1：质量不好，2：商品不满意，3：买错了，4：无理由退货
     */
    private Integer returnGoodsReason;

    /**
     * 退货备注
     */
    private String returnGoodsComment;

    /**
     * 退货快递单号
     */
    private String returnGoodsCourierNumber;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
