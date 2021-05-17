package com.codezealer.zmall.auth.mapper;

import com.codezealer.zmall.auth.entity.AccountPriorityRelationshipDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 账号与权限的关系表，一个账号可以对应多个权限，一个权限也可以属于多个账号 Mapper 接口
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface AuthAccountPriorityRelationshipMapper extends BaseMapper<AccountPriorityRelationshipDO> {

}
