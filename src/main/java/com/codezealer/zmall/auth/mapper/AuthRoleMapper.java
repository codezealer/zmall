package com.codezealer.zmall.auth.mapper;

import com.codezealer.zmall.auth.entity.AuthRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表，在系统中有多个角色，每个角色可以分配一些权限 Mapper 接口
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface AuthRoleMapper extends BaseMapper<AuthRole> {

}
