package com.codezealer.zmall.auth.mapper;

import com.codezealer.zmall.auth.entity.RolePriorityRelationshipDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色和权限的关系表，角色和权限是多对多的关系，一个角色可以对应多个权限，一个权限可以属于多个角色 Mapper 接口
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface AuthRolePriorityRelationshipMapper extends BaseMapper<RolePriorityRelationshipDO> {

}
