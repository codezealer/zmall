package com.codezealer.zmall.auth.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.auth.dao.RolePriorityRelationshipDAO;
import com.codezealer.zmall.auth.entity.RolePriorityRelationshipDO;
import com.codezealer.zmall.auth.mapper.AuthRolePriorityRelationshipMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO {

    @Resource
    AuthRolePriorityRelationshipMapper rolePriorityRelationshipMapper;

    @Override
    public Integer countRolePriorityRelationship(Long priorityId) {
        return rolePriorityRelationshipMapper.selectCount(new LambdaQueryWrapper<RolePriorityRelationshipDO>().eq(RolePriorityRelationshipDO::getPriorityId, priorityId));
    }
}
