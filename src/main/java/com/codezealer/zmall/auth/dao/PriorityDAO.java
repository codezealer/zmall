package com.codezealer.zmall.auth.dao;

import com.codezealer.zmall.auth.entity.PriorityDO;

import java.util.List;

public interface PriorityDAO {
    List<PriorityDO> listChildren(Long id);

    Boolean deleteById(Long id);

    PriorityDO selectById(Long priorityId);
}
