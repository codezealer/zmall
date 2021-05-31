package com.codezealer.zmall.inventory.async;

import com.codezealer.zmall.inventory.entity.InventoryOfflineStockUpdateMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Slf4j
public class OfflineResumeThread extends Thread {

    OfflineStorageManager offlineStorageManager;

    StockUpdateQueue stockUpdateQueue;

    public OfflineResumeThread(OfflineStorageManager offlineStorageManager, StockUpdateQueue stockUpdateQueue) {
        this.offlineStorageManager = offlineStorageManager;
        this.stockUpdateQueue = stockUpdateQueue;
    }


    @Override
    public void run() {
        try {
            List<StockUpdateMessage> stockUpdateMessages = offlineStorageManager.queryBatch();
            // 将这批数据写入内存队列中
            for(StockUpdateMessage message : stockUpdateMessages) {
                stockUpdateQueue.putDirect(message);
            }

            // 批量删除这批数据
            offlineStorageManager.removeByBatch(stockUpdateMessages);

        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
