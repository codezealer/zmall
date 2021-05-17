package com.codezealer.zmall.auth.service.impl;

import com.codezealer.zmall.auth.entity.AuthAccount;
import com.codezealer.zmall.auth.mapper.AuthAccountMapper;
import com.codezealer.zmall.auth.service.AuthAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号表，电商公司里一个员工就对应着一个账号，每个账号给分配多个角色，同时这个账号也可以给分配多个权限 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Service
public class AuthAccountServiceImpl extends ServiceImpl<AuthAccountMapper, AuthAccount> implements AuthAccountService {

}
