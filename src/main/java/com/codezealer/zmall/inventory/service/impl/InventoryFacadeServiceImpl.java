package com.codezealer.zmall.inventory.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.codezealer.zmall.inventory.async.StockUpdateMessage;
import com.codezealer.zmall.inventory.async.StockUpdateQueue;
import com.codezealer.zmall.inventory.async.StockUpdateResultManager;
import com.codezealer.zmall.inventory.constant.StockUpdateOperation;
import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.stock.*;
import com.codezealer.zmall.order.dto.OrderInfoDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.service.InventoryFacadeService;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class InventoryFacadeServiceImpl implements InventoryFacadeService {
    @Resource
    InventoryGoodsStockDAO inventoryGoodsStockDAO;

    @Resource
    PurchaseInputStockUpdaterFactory purchaseInputStockUpdaterFactory;
    @Resource
    ReturnGoodsInputStockUpdaterFactory returnGoodsInputStockUpdaterFactory;
    @Resource
    SubmitOrderStockUpdaterFactory submitOrderStockUpdaterFactory;
    @Resource
    PayOrderStockUpdaterFactory payOrderStockUpdaterFactory;
    @Resource
    CancelOrderStockUpdaterFactory cancelOrderStockUpdaterFactory;
    @Resource
    StockUpdateQueue stockUpdateQueue;
    @Resource
    StockUpdateResultManager stockUpdateResultManager;



    /**
     * 采购入库 更新库存
     * @param purchaseInputOrderDTO
     * @return
     */
    @Override
    public Boolean informPurchaseGoodsInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO) {
        StockUpdater stockUpdater = purchaseInputStockUpdaterFactory.create(purchaseInputOrderDTO);
        stockUpdater.updateGoodsStock();
        return true;
    }

    /**
     * 退货入库 更新库存
     * @param returnGoodsInputOrderDTO
     * @return
     */
    @Override
    public Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
        StockUpdater stockUpdater = returnGoodsInputStockUpdaterFactory.create(returnGoodsInputOrderDTO);
        return stockUpdater.updateGoodsStock();
    }

    /**
     * 提交订单
     * @param orderInfoDTO
     * @return
     */
    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            StockUpdater stockUpdater = submitOrderStockUpdaterFactory.create(orderInfoDTO);
            stockUpdater.updateGoodsStock();

            StockUpdateMessage<OrderInfoDTO> stockUpdateMessage = new StockUpdateMessage();
            stockUpdateMessage.setMessageId(RandomUtil.randomString(32));
            stockUpdateMessage.setOperation(StockUpdateOperation.SUBMIT_ORDER);
            stockUpdateMessage.setParameter(orderInfoDTO);
            stockUpdateQueue.put(stockUpdateMessage);

            stockUpdateResultManager.observe(stockUpdateMessage.getMessageId());

        } catch(Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    /**
     * 支付订单
     * @param orderInfoDTO
     * @return
     */
    @Override
    public Boolean informPayOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            StockUpdater stockUpdater = payOrderStockUpdaterFactory.create(orderInfoDTO);
            stockUpdater.updateGoodsStock();
            StockUpdateMessage<OrderInfoDTO> stockUpdateMessage = new StockUpdateMessage();
            stockUpdateMessage.setMessageId(RandomUtil.randomString(32));
            stockUpdateMessage.setOperation(StockUpdateOperation.PAY_ORDER);
            stockUpdateMessage.setParameter(orderInfoDTO);
            stockUpdateQueue.put(stockUpdateMessage);

            stockUpdateResultManager.observe(stockUpdateMessage.getMessageId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    /**
     * 取消订单
     * @param orderInfoDTO
     * @return
     */
    @Override
    public Boolean informCancelOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            StockUpdater stockUpdater = cancelOrderStockUpdaterFactory.create(orderInfoDTO);
            stockUpdater.updateGoodsStock();
            StockUpdateMessage<OrderInfoDTO> stockUpdateMessage = new StockUpdateMessage();
            stockUpdateMessage.setMessageId(RandomUtil.randomString(32));
            stockUpdateMessage.setOperation(StockUpdateOperation.CANCEL_ORDER);
            stockUpdateMessage.setParameter(orderInfoDTO);
            stockUpdateQueue.put(stockUpdateMessage);

            stockUpdateResultManager.observe(stockUpdateMessage.getMessageId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
