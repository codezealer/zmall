package com.codezealer.zmall.inventory.async;

import java.util.Observable;

public class StockUpdateObservable extends Observable {

    private String messageId;

    public StockUpdateObservable(String messageId) {
        this.messageId = messageId;
    }

    public void setResult(Boolean result) {
        StockUpdateResult stockUpdateResult = new StockUpdateResult();
        stockUpdateResult.setMessageId(this.messageId);
        stockUpdateResult.setResult(result);

        this.setChanged();
        this.notifyObservers(stockUpdateResult);
    }

}
