package com.codezealer.zmall.order.service.impl;

import com.codezealer.zmall.order.dao.OrderDAO;
import com.codezealer.zmall.order.service.OrderFacadeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderFacadeServiceImpl implements OrderFacadeService {

    @Resource
    OrderDAO orderDAO;

    @Override
    public void informCommentPublishedEvent(Long orderId) {
        orderDAO.updateCommentPublished(orderId);
    }
}
