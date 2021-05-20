package com.codezealer.zmall.promotion.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 促销活动表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PromotionActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 促销活动名称
     */
    private String promotionActivityName;

    /**
     * 促销活动开始时间
     */
    private LocalDateTime promotionActivityStartTime;

    /**
     * 促销活动结束时间
     */
    private LocalDateTime promotionActivityEndTime;

    /**
     * 促销活动说明备注
     */
    private String promotionActivityComment;

    /**
     * 促销活动的状态，1：启用，2：停用
     */
    private Integer promotionActivityStatus;

    /**
     * 促销活动的规则
     */
    private String promotionActivityRule;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
