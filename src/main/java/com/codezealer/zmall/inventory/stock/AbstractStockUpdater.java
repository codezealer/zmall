package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.constant.StockStatus;
import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
public abstract class AbstractStockUpdater implements StockUpdater {

    protected List<InventoryGoodsStock> goodsStockList;
    protected InventoryGoodsStockDAO goodsStockDAO;

    public AbstractStockUpdater(List<InventoryGoodsStock> goodsStockList, InventoryGoodsStockDAO goodsStockDAO) {
        this.goodsStockList = goodsStockList;
        this.goodsStockDAO = goodsStockDAO;
    }


    /**
     * 库存更新通用逻辑：
     * 更新销售库存
     * 更新锁定库存
     * 更新已售库存
     * 更新库存状态
     * 更新时间
     * @return
     */
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
        for (InventoryGoodsStock inventoryGoodsStock : goodsStockList) {
            inventoryGoodsStock.setStockStatus(inventoryGoodsStock.getSaleStockQuantity() > 0 ? StockStatus.IN_STOCK : StockStatus.OUT_STOCK);
        }
    }

    public  void updateGmtModified() {
        for (InventoryGoodsStock inventoryGoodsStock : goodsStockList) {
            inventoryGoodsStock.setGmtModified(LocalDateTime.now());
        }
    }

    public void executeUpdateGoodsStock() {
        for (InventoryGoodsStock inventoryGoodsStock : goodsStockList) {
            goodsStockDAO.saveOrUpdate(inventoryGoodsStock);
        }
    }

}
