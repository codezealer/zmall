package com.codezealer.zmall.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表，在系统中有多个角色，每个角色可以分配一些权限
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编号
     */
    private String code;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色的说明备注
     */
    private String roleComment;

    /**
     * 角色是否启用，1：启用，0：未启用
     */
    private Integer isEnabled;

    /**
     * 角色的创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 角色的修改时间
     */
    private LocalDateTime gmtModified;


}
