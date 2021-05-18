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
 * 账号和角色的关系表，一个账号可以对应多个角色，一个角色也可以对应多个账号
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "auth_account_role_relationship")
public class AccountRoleRelationshipDO implements Serializable {

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
     * 角色的主键
     */
    private Long roleId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
