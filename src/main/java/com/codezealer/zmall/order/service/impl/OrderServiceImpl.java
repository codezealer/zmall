package com.codezealer.zmall.order.service.impl;

import com.codezealer.zmall.order.entity.Order;
import com.codezealer.zmall.order.mapper.OrderMapper;
import com.codezealer.zmall.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
