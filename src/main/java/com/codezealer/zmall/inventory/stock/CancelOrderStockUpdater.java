package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.order.dto.OrderItemDTO;

import java.util.List;
import java.util.Map;

public class CancelOrderStockUpdater extends AbstractStockUpdater {

    Map<Long, OrderItemDTO> orderItemDTOMap;

    public CancelOrderStockUpdater(List<InventoryGoodsStock> goodsStockList,
                                   InventoryGoodsStockDAO goodsStockDAO,
                                   Map<Long, OrderItemDTO> orderItemDTOMap) {
        super(goodsStockList, goodsStockDAO);
        this.orderItemDTOMap = orderItemDTOMap;
    }

    @Override
    public void updateSaleStockQuantity() {
        goodsStockList.forEach(item -> {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaleStockQuantity(item.getSaleStockQuantity() + orderItemDTO.getPurchaseQuantity());
        });
    }

    @Override
    public void updateSaledStockQuantity() {
        goodsStockList.forEach(item -> {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaledStockQuantity(item.getSaledStockQuantity() - orderItemDTO.getPurchaseQuantity());
        });
    }

    @Override
    public void updateLockedStockQuantity() {

    }
}
