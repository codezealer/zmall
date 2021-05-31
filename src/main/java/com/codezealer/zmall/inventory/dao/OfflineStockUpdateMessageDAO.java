package com.codezealer.zmall.inventory.dao;

import com.codezealer.zmall.inventory.entity.InventoryOfflineStockUpdateMessage;

import java.util.List;

public interface OfflineStockUpdateMessageDAO {
    void save(InventoryOfflineStockUpdateMessage offlineStockUpdateMessage);

    List<InventoryOfflineStockUpdateMessage> queryBatch();

    void removeByBatch(String messageIds);
}
