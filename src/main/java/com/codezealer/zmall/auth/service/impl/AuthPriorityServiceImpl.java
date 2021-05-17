package com.codezealer.zmall.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.auth.dto.PriorityDTO;
import com.codezealer.zmall.auth.entity.AuthPriority;
import com.codezealer.zmall.auth.mapper.AuthPriorityMapper;
import com.codezealer.zmall.auth.service.AuthPriorityService;
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
public class AuthPriorityServiceImpl extends ServiceImpl<AuthPriorityMapper, AuthPriority> implements AuthPriorityService {

    @Resource
    AuthPriorityMapper authPriorityMapper;

    @Override
    public List<PriorityDTO> listRootPriorities() {
        List<AuthPriority> list = authPriorityMapper.selectList(new LambdaQueryWrapper<AuthPriority>().eq(AuthPriority::getParentId, 0));
        List<PriorityDTO> priorityDTOList = new ArrayList<>(list.size());
        for (AuthPriority authPriority : list) {
            priorityDTOList.add(authPriority.clone(PriorityDTO.class));
        }
        return null;
    }
}
