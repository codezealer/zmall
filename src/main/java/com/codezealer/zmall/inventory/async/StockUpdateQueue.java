package com.codezealer.zmall.inventory.async;

public interface StockUpdateQueue<T> {

    void put(StockUpdateMessage<T> stockUpdateMessage) throws Exception;

    void putDirect(StockUpdateMessage<T> stockUpdateMessage) throws Exception;

    StockUpdateMessage<T> take() throws Exception;

    int size();


}
