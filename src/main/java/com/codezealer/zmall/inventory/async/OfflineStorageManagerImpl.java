package com.codezealer.zmall.inventory.async;

import cn.hutool.json.JSONUtil;
import com.codezealer.zmall.inventory.dao.OfflineStockUpdateMessageDAO;
import com.codezealer.zmall.inventory.entity.InventoryOfflineStockUpdateMessage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OfflineStorageManagerImpl implements OfflineStorageManager {

    private Boolean offline = false;

    @Resource
    OfflineStockUpdateMessageDAO offlineStockUpdateMessageDAO;

    @Override
    public void store(StockUpdateMessage message) {
        InventoryOfflineStockUpdateMessage offlineStockUpdateMessage = createStockUpdateMessageDO(message);
        offlineStockUpdateMessageDAO.save(offlineStockUpdateMessage);
    }

    private InventoryOfflineStockUpdateMessage createStockUpdateMessageDO(StockUpdateMessage message) {
        InventoryOfflineStockUpdateMessage stockUpdateMessageDO = new InventoryOfflineStockUpdateMessage();
        stockUpdateMessageDO.setMessageId(message.getMessageId());
        stockUpdateMessageDO.setOperation(message.getOperation());
        stockUpdateMessageDO.setParameter(JSONUtil.toJsonStr(message.getParameter()));
        stockUpdateMessageDO.setParameterClazz(message.getParameter().getClass().getName());
        stockUpdateMessageDO.setGmtCreate(LocalDateTime.now());
        stockUpdateMessageDO.setGmtModified(LocalDateTime.now());
        return stockUpdateMessageDO;
    }

    @Override
    public Boolean getOffline() {
        return offline;
    }

    @Override
    public void setOffline(Boolean offline) {
        this.offline = offline;
    }

    @Override
    public List<StockUpdateMessage> queryBatch() throws Exception {
        List<InventoryOfflineStockUpdateMessage> offlineStockUpdateMessageList = offlineStockUpdateMessageDAO.queryBatch();
        List<StockUpdateMessage> stockUpdateMessages = new ArrayList<>();
        for(InventoryOfflineStockUpdateMessage stockUpdateMessageDO : offlineStockUpdateMessageList) {
            StockUpdateMessage stockUpdateMessage = new StockUpdateMessage();
            stockUpdateMessage.setMessageId(stockUpdateMessageDO.getMessageId());
            stockUpdateMessage.setOperation(stockUpdateMessageDO.getOperation());
            stockUpdateMessage.setParameter(JSONUtil.toBean(stockUpdateMessageDO.getParameter(), Class.forName(stockUpdateMessageDO.getParameterClazz())));
            stockUpdateMessages.add(stockUpdateMessage);
        }
        return stockUpdateMessages;
    }

    @Override
    public void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) {
        String messageIds = stockUpdateMessages.stream().map(StockUpdateMessage::getMessageId).collect(Collectors.joining(","));
        offlineStockUpdateMessageDAO.removeByBatch(messageIds);
    }
}
