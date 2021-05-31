package com.codezealer.zmall.inventory.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

@Slf4j
@Component
public class StockUpdateQueueImpl implements StockUpdateQueue{

    private static final int QUEUE_SIZE = 1000;

    private static Boolean OFF_LINE = false;

    ArrayBlockingQueue<StockUpdateMessage> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);


    @Override
    public void put(StockUpdateMessage stockUpdateMessage) {
        try {
            queue.put(stockUpdateMessage);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void putDirect(StockUpdateMessage stockUpdateMessage) {
        try {
            queue.put(stockUpdateMessage);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public StockUpdateMessage take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public int size() {
        return queue.size();
    }

}
