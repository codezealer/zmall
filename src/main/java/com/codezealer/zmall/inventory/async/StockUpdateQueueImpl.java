package com.codezealer.zmall.inventory.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;

@Slf4j
@Component
public class StockUpdateQueueImpl implements StockUpdateQueue{

    private static final int QUEUE_SIZE = 1000;

    private ArrayBlockingQueue<StockUpdateMessage> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    @Resource
    private OfflineStorageManager offlineStorageManager;


    @Override
    public void put(StockUpdateMessage stockUpdateMessage) throws Exception {
        //如果是离线存储状态
        if (offlineStorageManager.getOffline()) {
            offlineStorageManager.store(stockUpdateMessage);
            if (queue.size() == 0) {
                new OfflineResumeThread(offlineStorageManager, this).start();
            }
            return;
        }
        if (QUEUE_SIZE <= queue.size()) {
            offlineStorageManager.store(stockUpdateMessage);
            offlineStorageManager.setOffline(true);
            return;
        }
        queue.put(stockUpdateMessage);
    }

    @Override
    public void putDirect(StockUpdateMessage stockUpdateMessage) throws Exception {
        queue.put(stockUpdateMessage);
    }

    @Override
    public StockUpdateMessage take() throws Exception {
        return queue.take();
    }

    @Override
    public int size() {
        return queue.size();
    }

}
