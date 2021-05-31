package com.codezealer.zmall.inventory.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.inventory.dao.OfflineStockUpdateMessageDAO;
import com.codezealer.zmall.inventory.entity.InventoryOfflineStockUpdateMessage;
import com.codezealer.zmall.inventory.mapper.InventoryOfflineStockUpdateMessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Slf4j
public class OfflineStockUpdateMessageDAOImpl implements OfflineStockUpdateMessageDAO {

    @Resource
    InventoryOfflineStockUpdateMessageMapper stockUpdateMessageMapper;

    @Override
    public void save(InventoryOfflineStockUpdateMessage offlineStockUpdateMessage) {
        stockUpdateMessageMapper.insert(offlineStockUpdateMessage);
    }

    @Override
    public List<InventoryOfflineStockUpdateMessage> queryBatch() {
        return stockUpdateMessageMapper.selectList(new LambdaQueryWrapper<InventoryOfflineStockUpdateMessage>()
                                                        .orderByAsc(InventoryOfflineStockUpdateMessage::getId)
                                                        .last("limit 50"));
    }

    @Override
    public void removeByBatch(String messageIds) {
        stockUpdateMessageMapper.delete(new LambdaQueryWrapper<InventoryOfflineStockUpdateMessage>().in(InventoryOfflineStockUpdateMessage::getMessageId, messageIds));
    }
}
