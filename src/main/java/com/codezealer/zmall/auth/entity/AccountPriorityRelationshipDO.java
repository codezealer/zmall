package com.codezealer.zmall.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * <p>
 * 账号与权限的关系表，一个账号可以对应多个权限，一个权限也可以属于多个账号
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)

@Table(name = "auth_account_priority_relationship")
public class AccountPriorityRelationshipDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号的主键
     */
    private Long accountId;

    /**
     * 权限的主键
     */
    private Long priorityId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
