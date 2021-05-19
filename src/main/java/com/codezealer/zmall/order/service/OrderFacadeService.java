package com.codezealer.zmall.order.service;

/**
 * 订单中心对外提供接口
 */
public interface OrderFacadeService {


    /**
     * 通知订单评论发表完成
     * @param orderId
     */
    void informCommentPublishedEvent(Long orderId);
}
