package com.codezealer.zmall.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.auth.dao.AccountPriorityRelationshipDAO;
import com.codezealer.zmall.auth.dao.PriorityDAO;
import com.codezealer.zmall.auth.dao.RolePriorityRelationshipDAO;
import com.codezealer.zmall.auth.dto.PriorityDTO;
import com.codezealer.zmall.auth.entity.PriorityDO;
import com.codezealer.zmall.auth.mapper.AuthPriorityMapper;
import com.codezealer.zmall.auth.service.PriorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限表，每个权限代表了系统中的一个菜单、按钮、URL请求 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@Service
public class PriorityServiceImpl extends ServiceImpl<AuthPriorityMapper, PriorityDO> implements PriorityService {

    @Resource
    AuthPriorityMapper authPriorityMapper;
    @Resource
    PriorityDAO priorityDAO;
    @Resource
    AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;

    @Resource
    RolePriorityRelationshipDAO rolePriorityRelationshipDAO;

    @Override
    public List<PriorityDTO> listRootPriorities() {
        List<PriorityDO> list = authPriorityMapper.selectList(new LambdaQueryWrapper<PriorityDO>().eq(PriorityDO::getParentId, 0));
        List<PriorityDTO> priorityDTOList = new ArrayList<>(list.size());
        for (PriorityDO priorityDO : list) {
            priorityDTOList.add(priorityDO.clone(PriorityDTO.class));
        }
        return priorityDTOList;
    }

    @Override
    public List<PriorityDTO> listChildPriority(Long id) {
        List<PriorityDO> list = authPriorityMapper.selectList(new LambdaQueryWrapper<PriorityDO>().eq(PriorityDO::getParentId, id));
        List<PriorityDTO> priorityDTOList = new ArrayList<>(list.size());
        for (PriorityDO priorityDO : list) {
            priorityDTOList.add(priorityDO.clone(PriorityDTO.class));
        }
        return priorityDTOList;
    }

    @Override
    public PriorityDTO getPriority(Long id) {
        PriorityDO priorityDO = authPriorityMapper.selectById(id);
        return priorityDO.clone(PriorityDTO.class);
    }

    @Override
    public boolean savePriority(PriorityDTO priorityDTO) {
        return authPriorityMapper.insert(priorityDTO.clone(PriorityDO.class)) > 0 ? true : false;
    }

    @Override
    public boolean updatePriority(PriorityDTO priorityDTO) {
        return authPriorityMapper.updateById(priorityDTO.clone(PriorityDO.class)) > 0 ? true : false;
    }

    /**
     *
     * 删除当前节点以及下面的所有子节点
     * @param priorityId
     * @return
     */
    @Override
    public boolean deletePriority(Long priorityId) {
        List<PriorityDO> children = priorityDAO.listChildren(priorityId);
        if (children != null && children.size() > 0) {
            for (PriorityDO child : children) {
                deletePriority(child.getId());
            }
        }
        priorityDAO.deleteById(priorityId);
        return true;
    }

    private boolean isRelated = false;

    /**
     * 查看当前节点及子节点是否有关联的角色或者账号
     * @param priorityId
     * @return
     */
    public boolean checkRelate(Long priorityId) {
        int accountRelationShipCount = accountPriorityRelationshipDAO.countAccountRelationShip(priorityId);
        if (accountRelationShipCount > 0) {
            isRelated = true;
        }
        List<PriorityDO> children = priorityDAO.listChildren(priorityId);
        if (children != null && children.size() > 0) {
            for (PriorityDO child : children) {
                isRelated = checkRelate(child.getId());
            }
        }

        int roleRelationshipCount = accountPriorityRelationshipDAO.countAccountRelationShip(priorityId);
        if (roleRelationshipCount > 0) {
            isRelated = true;
        }
        return isRelated;
    }
}
