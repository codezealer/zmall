package com.codezealer.zmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员等级变更的明细表
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MembershipMemberLevelDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员等级信息ID
     */
    private Long memberLevelId;

    /**
     * 本次变动之前的成长值
     */
    private Long oldGrowthValue;

    /**
     * 本次变动了多少成长值
     */
    private Long updatedGrowthValue;

    /**
     * 本次变动之后的成长值
     */
    private Long newGrowthValue;

    /**
     * 本次变动之前的会员等级
     */
    private Integer oldMemberLevel;

    /**
     * 本次变动后的会员级别
     */
    private Integer newMemberLevel;

    /**
     * 变动原因
     */
    private String updateReason;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
