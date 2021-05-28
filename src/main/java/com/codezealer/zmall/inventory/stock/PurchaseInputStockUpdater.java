package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderItemDTO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseInputStockUpdater extends AbstractStockUpdater {

    Map<Long, PurchaseInputOrderItemDTO> purcahseInputOrderItemDTOMap;

    public PurchaseInputStockUpdater(List<InventoryGoodsStock> goodsStockList, InventoryGoodsStockDAO inventoryGoodsStockDAO,
                                    Map<Long, PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOMap) {
        super(goodsStockList, inventoryGoodsStockDAO);
        this.purcahseInputOrderItemDTOMap = purchaseInputOrderItemDTOMap;
    }

    @Override
    public void updateSaleStockQuantity() {
        this.inventoryGoodsStockList.forEach(item -> {
            PurchaseInputOrderItemDTO purchaseInputOrderItemDTO = this.purcahseInputOrderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaleStockQuantity(item.getSaleStockQuantity() + purchaseInputOrderItemDTO.getArrivalCount());
            this.inventoryGoodsStockDAO.saveOrUpdate(item);
        });
    }

    @Override
    public void updateSaledStockQuantity() {

    }

    @Override
    public void updateLockedStockQuantity() {

    }
}
