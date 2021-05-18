package com.codezealer.zmall.auth.mapper;

import com.codezealer.zmall.auth.entity.PriorityDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表，每个权限代表了系统中的一个菜单、按钮、URL请求 Mapper 接口
 * </p>
 *
 * @author codezealer
 * @since 2021-05-17
 */

@Mapper
public interface AuthPriorityMapper extends BaseMapper<PriorityDO> {


}
