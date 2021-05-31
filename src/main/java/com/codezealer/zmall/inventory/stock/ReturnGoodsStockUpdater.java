package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.order.dto.OrderItemDTO;
import com.codezealer.zmall.order.entity.OrderItem;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderItemDTO;

import java.util.List;
import java.util.Map;

public class ReturnGoodsStockUpdater extends AbstractStockUpdater {

    Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap;

    public ReturnGoodsStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList,
                                   InventoryGoodsStockDAO inventoryGoodsStockDAO,
                                   Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap) {
        super(inventoryGoodsStockList, inventoryGoodsStockDAO);
        this.returnGoodsInputOrderItemDTOMap = returnGoodsInputOrderItemDTOMap;
    }

    @Override
    public void updateSaleStockQuantity() {
        goodsStockList.forEach(item -> {
            ReturnGoodsInputOrderItemDTO orderItemDTO = returnGoodsInputOrderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaleStockQuantity(item.getSaleStockQuantity() + orderItemDTO.getArrivalCount());
        });
    }

    @Override
    public void updateSaledStockQuantity() {
        goodsStockList.forEach(item -> {
            ReturnGoodsInputOrderItemDTO orderItemDTO = returnGoodsInputOrderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaledStockQuantity(item.getSaledStockQuantity() - orderItemDTO.getArrivalCount());
        });
    }

    @Override
    public void updateLockedStockQuantity() {

    }
}
