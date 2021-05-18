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
 * 账号表，电商公司里一个员工就对应着一个账号，每个账号给分配多个角色，同时这个账号也可以给分配多个权限
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "auth_account")
public class AccountDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名，英文
     */
    private String username;

    /**
     * 账号的密码
     */
    private Integer password;

    /**
     * 姓名，中文
     */
    private String employeName;

    /**
     * 账号的说明备注
     */
    private String accountComment;

    /**
     * 账号是否启用，1：启用，0：未启用
     */
    private Integer isEnabled;

    /**
     * 账号的创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 账号的更新时间
     */
    private LocalDateTime gmtModified;


}
