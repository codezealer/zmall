package com.codezealer.zmall.inventory.async;

public interface StockUpdateResultManager {


    void observe(String messageId);

    void inform(String messageId, Boolean result);

    StockUpdateObservable getObservable(String messageId);
}
