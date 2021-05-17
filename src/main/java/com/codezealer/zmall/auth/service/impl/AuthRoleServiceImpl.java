package com.codezealer.zmall.auth.service.impl;

import com.codezealer.zmall.auth.entity.AuthRole;
import com.codezealer.zmall.auth.mapper.AuthRoleMapper;
import com.codezealer.zmall.auth.service.AuthRoleService;
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
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements AuthRoleService {

}
