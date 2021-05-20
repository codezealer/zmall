package com.codezealer.zmall.inventory.dao;

import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;

public interface InventoryGoodsStockDAO {
    InventoryGoodsStock getByGoodsSkuId(Long goodsSkuId);

    void saveOrUpdate(InventoryGoodsStock inventoryGoodsStock);
}
