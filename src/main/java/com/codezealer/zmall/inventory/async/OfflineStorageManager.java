package com.codezealer.zmall.inventory.async;

import com.codezealer.zmall.inventory.entity.InventoryOfflineStockUpdateMessage;
import lombok.Data;

import java.util.List;

public interface OfflineStorageManager {

    void store(StockUpdateMessage message);

    Boolean getOffline();

    void setOffline(Boolean offline);

    List<StockUpdateMessage> queryBatch() throws ClassNotFoundException, Exception;

    void removeByBatch(List<StockUpdateMessage> stockUpdateMessages);
}
