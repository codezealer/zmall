package com.codezealer.zmall.inventory.async;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StockUpdateResultManagerImpl implements StockUpdateResultManager {

    Map<String, StockUpdateObservable> observableMap = new ConcurrentHashMap<>();

    @Resource
    StockUpdateObserver observer;


    @Override
    public void observe(String messageId) {
        StockUpdateObservable stockUpdateObservable = new StockUpdateObservable(messageId);
        stockUpdateObservable.addObserver(observer);
        observableMap.put(messageId, stockUpdateObservable);
    }

    @Override
    public void inform(String messageId, Boolean result) {
        StockUpdateObservable stockUpdateObservable = observableMap.get(messageId);
        stockUpdateObservable.setResult(result);
        observableMap.remove(messageId);
    }

    @Override
    public StockUpdateObservable getObservable(String messageId) {
        return observableMap.get(messageId);
    }
}
