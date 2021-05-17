package com.codezealer.zmall.auth.service.impl;

import com.codezealer.zmall.auth.entity.RoleDO;
import com.codezealer.zmall.auth.mapper.AuthRoleMapper;
import com.codezealer.zmall.auth.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表，在系统中有多个角色，每个角色可以分配一些权限 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<AuthRoleMapper, RoleDO> implements RoleService {

}
