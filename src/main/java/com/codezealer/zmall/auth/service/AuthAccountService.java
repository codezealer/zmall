package com.codezealer.zmall.auth.service;

import com.codezealer.zmall.auth.entity.AuthAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账号表，电商公司里一个员工就对应着一个账号，每个账号给分配多个角色，同时这个账号也可以给分配多个权限 服务类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface AuthAccountService extends IService<AuthAccount> {

}
