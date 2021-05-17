package com.codezealer.zmall.auth.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.auth.dao.AccountPriorityRelationshipDAO;
import com.codezealer.zmall.auth.entity.AccountPriorityRelationshipDO;
import com.codezealer.zmall.auth.mapper.AuthAccountPriorityRelationshipMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO {

    @Resource
    AuthAccountPriorityRelationshipMapper authAccountPriorityRelationshipMapper;

    @Override
    public Integer countAccountRelationShip(Long priorityId) {
        return authAccountPriorityRelationshipMapper.selectCount(new LambdaQueryWrapper<AccountPriorityRelationshipDO>().eq(AccountPriorityRelationshipDO::getPriorityId, priorityId));
    }
}
