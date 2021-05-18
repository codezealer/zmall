package com.codezealer.zmall.auth.controller;


import com.codezealer.zmall.auth.dto.PriorityDTO;
import com.codezealer.zmall.auth.entity.PriorityDO;
import com.codezealer.zmall.auth.service.PriorityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表，每个权限代表了系统中的一个菜单、按钮、URL请求 前端控制器
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/auth-priority")
public class AuthPriorityController {

    @Resource
    PriorityService priorityService;

    @RequestMapping("/root")
    public List<PriorityDTO> getRoot() {
        return priorityService.listRootPriorities();
    }

    @RequestMapping("/getChildPriority/{id}")
    public List<PriorityDTO> getChildPriority(@PathVariable("id") Long id) {
        return priorityService.listChildPriority(id);
    }

    @RequestMapping("/get/{id}")
    public PriorityDTO getPriority(@PathVariable("id") Long priorityId) {
        return priorityService.getPriority(priorityId);
    }

    @RequestMapping("/save")
    public boolean savePriority(@RequestBody PriorityDTO priorityDTO) {
        return priorityService.savePriority(priorityDTO);
    }

    @RequestMapping("/delete/{id}")
    public boolean deletePriority(@PathVariable("id") Long priorityId) {
        return priorityService.deletePriority(priorityId);
    }
}

