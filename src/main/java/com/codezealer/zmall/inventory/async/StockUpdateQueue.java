package com.codezealer.zmall.inventory.async;

public interface StockUpdateQueue {

    void put(StockUpdateMessage stockUpdateMessage) throws InterruptedException;

    void putDirect(StockUpdateMessage stockUpdateMessage);

    StockUpdateMessage take();

    int size();


}
