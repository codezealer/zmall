package com.codezealer.zmall.order.service.impl;

import com.codezealer.zmall.order.entity.OrderItem;
import com.codezealer.zmall.order.mapper.OrderItemMapper;
import com.codezealer.zmall.order.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品条目 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
