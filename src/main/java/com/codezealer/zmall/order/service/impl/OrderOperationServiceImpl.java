package com.codezealer.zmall.order.service.impl;

import com.codezealer.zmall.order.entity.OrderOperation;
import com.codezealer.zmall.order.mapper.OrderOperationMapper;
import com.codezealer.zmall.order.service.OrderOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单操作记录表 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class OrderOperationServiceImpl extends ServiceImpl<OrderOperationMapper, OrderOperation> implements OrderOperationService {

}
