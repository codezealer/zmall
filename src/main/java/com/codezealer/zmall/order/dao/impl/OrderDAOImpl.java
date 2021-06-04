package com.codezealer.zmall.order.dao.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.codezealer.zmall.order.dao.OrderDAO;
import com.codezealer.zmall.order.entity.Order;
import com.codezealer.zmall.order.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Resource
    OrderMapper orderMapper;


    @Override
    public void updateCommentPublished(Long orderId) {
        Order order = new Order();
        order.setIsCommentPublished(true);
        orderMapper.update(order, new LambdaUpdateWrapper<Order>().eq(Order::getId, orderId));
    }
}
