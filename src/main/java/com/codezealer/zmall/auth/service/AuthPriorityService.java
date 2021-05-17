package com.codezealer.zmall.auth.service;

import com.codezealer.zmall.auth.dto.PriorityDTO;
import com.codezealer.zmall.auth.entity.AuthPriority;
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
public interface AuthPriorityService extends IService<AuthPriority> {
    List<PriorityDTO> listRootPriorities();
}
