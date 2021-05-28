package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.constant.StockStatus;
import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
public abstract class AbstractStockUpdater implements StockUpdater {

    protected List<InventoryGoodsStock> inventoryGoodsStockList;
    protected InventoryGoodsStockDAO inventoryGoodsStockDAO;

    public AbstractStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList, InventoryGoodsStockDAO inventoryGoodsStockDAO) {
        this.inventoryGoodsStockList = inventoryGoodsStockList;
        this.inventoryGoodsStockDAO = inventoryGoodsStockDAO;
    }


    @Override
    public Boolean updateGoodsStock() {
        try {
            updateSaleStockQuantity();
            updateSaledStockQuantity();
            updateLockedStockQuantity();
            updateStockStatus();
            updateGmtModified();
            executeUpdateGoodsStock();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    public abstract void updateSaleStockQuantity();

    public abstract void updateSaledStockQuantity();

    public abstract void updateLockedStockQuantity();

    public void updateStockStatus() {
        for (InventoryGoodsStock inventoryGoodsStock : inventoryGoodsStockList) {
            inventoryGoodsStock.setStockStatus(inventoryGoodsStock.getSaleStockQuantity() > 0 ? StockStatus.IN_STOCK : StockStatus.OUT_STOCK);
        }
    }

    public  void updateGmtModified() {
        for (InventoryGoodsStock inventoryGoodsStock : inventoryGoodsStockList) {
            inventoryGoodsStock.setGmtModified(LocalDateTime.now());
        }
    }

    public void executeUpdateGoodsStock() {
        for (InventoryGoodsStock inventoryGoodsStock : inventoryGoodsStockList) {
            inventoryGoodsStockDAO.saveOrUpdate(inventoryGoodsStock);
        }
    }

}
