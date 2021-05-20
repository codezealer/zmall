package com.codezealer.zmall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单退货表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderReturnGoods implements Serializable {

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
     * 退货原因，1：质量不好，2：商品不满意，3：买错了，4：无理由退货
     */
    private Integer returnGoodsReason;

    /**
     * 退货备注
     */
    private String returnGoodsComment;

    /**
     * 退货记录状态，1：待审核，2：审核不通过，3：待寄送退货商品，4：退货商品待收货，5：退货待入库，6：退货已入库，7：完成退款
     */
    private Integer returnGoodsStatus;

    /**
     * 退货收货人
     */
    private String returnGoodsConsignee;

    /**
     * 退货收货地址
     */
    private String returnGoodsDeliveryAddress;

    /**
     * 退货收货人的联系电话
     */
    private String returnGoodsConsigneeCellPhoneNumber;

    /**
     * 退货快递单号
     */
    private String courierNumber;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
