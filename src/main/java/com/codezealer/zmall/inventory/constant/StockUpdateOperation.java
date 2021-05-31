package com.codezealer.zmall.inventory.constant;

public interface StockUpdateOperation {

    /**
     * 提交订单
     */
    int SUBMIT_ORDER = 1;

    /**
     * 支付订单
     */
    int PAY_ORDER = 2;

    /**
     * 取消订单
     */
    int CANCEL_ORDER = 3;


}
