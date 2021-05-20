package com.codezealer.zmall.promotion.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 优惠券表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PromotionCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券类型，1：现金券，2：满减券
     */
    private Integer couponType;

    /**
     * 优惠券规则
     */
    private String couponRule;

    /**
     * 有效期开始时间
     */
    private LocalDateTime validStartTime;

    /**
     * 有效期结束时间
     */
    private LocalDateTime validEndTime;

    /**
     * 优惠券发行数量
     */
    private Long couponCount;

    /**
     * 优惠券已经领取的数量
     */
    private Long couponReceivedCount;

    /**
     * 优惠券发放方式，1：可发放可领取，2：仅可发放，3：仅可领取
     */
    private Integer couponReceiveType;

    /**
     * 优惠券状态，1：发放中，2：已发完，3：过期
     */
    private Integer couponStatus;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
