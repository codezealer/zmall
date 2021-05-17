package com.codezealer.zmall.auth.service;

import com.codezealer.zmall.auth.dto.PriorityDTO;
import com.codezealer.zmall.auth.entity.PriorityDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表，每个权限代表了系统中的一个菜单、按钮、URL请求 服务类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
public interface PriorityService extends IService<PriorityDO> {
    List<PriorityDTO> listRootPriorities();

    List<PriorityDTO> listChildPriority(Long id);

    PriorityDTO getPriority(Long id);

    boolean savePriority(PriorityDTO priorityDTO);

    boolean updatePriority(PriorityDTO priorityDTO);

    boolean deletePriority1(Long id);

    boolean deletePriority(Long priorityId);
}
