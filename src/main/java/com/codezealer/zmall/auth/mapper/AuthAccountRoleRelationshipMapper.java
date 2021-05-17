package com.codezealer.zmall.auth.mapper;

import com.codezealer.zmall.auth.entity.AccountRoleRelationshipDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 账号和角色的关系表，一个账号可以对应多个角色，一个角色也可以对应多个账号 Mapper 接口
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface AuthAccountRoleRelationshipMapper extends BaseMapper<AccountRoleRelationshipDO> {

}
