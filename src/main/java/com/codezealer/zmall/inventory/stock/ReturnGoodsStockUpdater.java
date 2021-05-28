package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;

import java.util.List;

public class ReturnGoodsStockUpdater extends AbstractStockUpdater {


    public ReturnGoodsStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList, InventoryGoodsStockDAO inventoryGoodsStockDAO) {
        super(inventoryGoodsStockList, inventoryGoodsStockDAO);
    }

    @Override
    public void updateSaleStockQuantity() {

    }

    @Override
    public void updateSaledStockQuantity() {

    }

    @Override
    public void updateLockedStockQuantity() {

    }
}
