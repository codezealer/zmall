package com.codezealer.zmall.inventory.service.impl;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.dto.OrderInfoDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.service.InventoryFacadeService;
import com.codezealer.zmall.inventory.stock.PurchaseInputStockUpdaterFactory;
import com.codezealer.zmall.inventory.stock.ReturnGoodsInputStockUpdaterFactory;
import com.codezealer.zmall.inventory.stock.StockUpdater;
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

        return null;
    }
}
