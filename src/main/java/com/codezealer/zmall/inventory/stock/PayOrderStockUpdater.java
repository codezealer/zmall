package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.order.dto.OrderItemDTO;

import java.util.List;
import java.util.Map;

public class PayOrderStockUpdater extends AbstractStockUpdater {
    Map<Long, OrderItemDTO> orderItemDTOMap;

    public PayOrderStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList,
                                InventoryGoodsStockDAO goodsStockDAO,
                                Map<Long, OrderItemDTO> orderItemDTOMap) {
        super(inventoryGoodsStockList, goodsStockDAO);
        this.orderItemDTOMap = orderItemDTOMap;
    }

    @Override
    public void updateSaleStockQuantity() {

    }

    @Override
    public void updateSaledStockQuantity() {
        this.goodsStockList.forEach(item -> {
            OrderItemDTO orderItemDTO = this.orderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaledStockQuantity(item.getSaledStockQuantity() + orderItemDTO.getPurchaseQuantity());
        });
    }

    @Override
    public void updateLockedStockQuantity() {
        this.goodsStockList.forEach(item -> {
            OrderItemDTO orderItemDTO = this.orderItemDTOMap.get(item.getGoodsSkuId());
            item.setLockedStockQuantity(item.getLockedStockQuantity() - orderItemDTO.getPurchaseQuantity());
        });
    }
}
