package com.codezealer.zmall.auth.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.auth.dao.PriorityDAO;
import com.codezealer.zmall.auth.entity.PriorityDO;
import com.codezealer.zmall.auth.mapper.AuthPriorityMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PriorityDAOImpl implements PriorityDAO {
    @Resource
    AuthPriorityMapper priorityMapper;

    @Override
    public List<PriorityDO> listChildren(Long id) {
        return priorityMapper.selectList(new LambdaQueryWrapper<PriorityDO>().eq(PriorityDO::getParentId, id));
    }

    @Override
    public Boolean deleteById(Long id) {
        return priorityMapper.deleteById(id) > 0 ? true : false;
    }

    @Override
    public PriorityDO selectById(Long priorityId) {
        return priorityMapper.selectById(priorityId);
    }

}
