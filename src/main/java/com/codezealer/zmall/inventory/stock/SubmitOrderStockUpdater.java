package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.order.dto.OrderItemDTO;

import java.util.List;
import java.util.Map;

/**
 * 提交订单更新库存
 */
public class SubmitOrderStockUpdater extends AbstractStockUpdater {
    Map<Long, OrderItemDTO> orderItemDTOMap;

    public SubmitOrderStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList,
                                   InventoryGoodsStockDAO inventoryGoodsStockDAO,
                                   Map<Long, OrderItemDTO> orderItemDTOMap) {
        super(inventoryGoodsStockList, inventoryGoodsStockDAO);
        this.orderItemDTOMap = orderItemDTOMap;
    }

    @Override
    public void updateSaleStockQuantity() {
        this.goodsStockList.forEach(item -> {
            OrderItemDTO orderItemDTO = this.orderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaleStockQuantity(item.getSaleStockQuantity() - orderItemDTO.getPurchaseQuantity());
            this.goodsStockDAO.saveOrUpdate(item);
        });
    }

    @Override
    public void updateSaledStockQuantity() {

    }

    @Override
    public void updateLockedStockQuantity() {
        this.goodsStockList.forEach(item -> {
            OrderItemDTO orderItemDTO = this.orderItemDTOMap.get(item.getGoodsSkuId());
            item.setLockedStockQuantity(item.getLockedStockQuantity() + orderItemDTO.getPurchaseQuantity());
            this.goodsStockDAO.saveOrUpdate(item);
        });
    }
}
