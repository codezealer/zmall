package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;

import java.util.List;

/**
 * 提交订单更新库存
 */
public class SubmitOrderStockUpdater extends AbstractStockUpdater {

    public SubmitOrderStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList, InventoryGoodsStockDAO inventoryGoodsStockDAO) {
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
