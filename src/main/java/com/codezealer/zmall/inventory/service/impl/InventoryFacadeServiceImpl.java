package com.codezealer.zmall.inventory.service.impl;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.stock.*;
import com.codezealer.zmall.order.dto.OrderInfoDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.service.InventoryFacadeService;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDTO orderInfoDTO) {
        StockUpdater stockUpdater = submitOrderStockUpdaterFactory.create(orderInfoDTO);
        return stockUpdater.updateGoodsStock();
    }

    @Override
    public Boolean informPayOrderEvent(OrderInfoDTO orderInfoDTO) {
        StockUpdater stockUpdater = payOrderStockUpdaterFactory.create(orderInfoDTO);
        return stockUpdater.updateGoodsStock();
    }

    @Override
    public Boolean informCancelOrderEvent(OrderInfoDTO orderInfoDTO) {
        StockUpdater stockUpdater = cancelOrderStockUpdaterFactory.create(orderInfoDTO);
        return stockUpdater.updateGoodsStock();
    }
}
