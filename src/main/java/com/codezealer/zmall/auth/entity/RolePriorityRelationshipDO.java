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
 * 角色和权限的关系表，角色和权限是多对多的关系，一个角色可以对应多个权限，一个权限可以属于多个角色
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "auth_role_priority_relationship")
public class RolePriorityRelationshipDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限的主键
     */
    private Long priorityId;

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
