package com.codezealer.zmall.auth.mapper;

import com.codezealer.zmall.auth.entity.AuthAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 账号表，电商公司里一个员工就对应着一个账号，每个账号给分配多个角色，同时这个账号也可以给分配多个权限 Mapper 接口
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface AuthAccountMapper extends BaseMapper<AuthAccount> {

}
