package com.codezealer.zmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员积分变动的明细表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MembershipMemberPointDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员积分ID
     */
    private Long memberPointId;

    /**
     * 本次变动之前的会员积分
     */
    private String oldMemberPoint;

    /**
     * 本次变动的会员积分
     */
    private Long updatedMemberPoint;

    /**
     * 本次变动之后的会员积分
     */
    private Long newMemberPoint;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 本次积分变动的原因
     */
    private String updateReason;


}
