package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderItemDTO;

import java.util.List;
import java.util.Map;

public class ReturnGoodsInputStockUpdater extends AbstractStockUpdater {

    Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap;

    public ReturnGoodsInputStockUpdater(List<InventoryGoodsStock> inventoryGoodsStockList, InventoryGoodsStockDAO inventoryGoodsStockDAO,
                                        Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap) {
        super(inventoryGoodsStockList, inventoryGoodsStockDAO);
        this.returnGoodsInputOrderItemDTOMap = returnGoodsInputOrderItemDTOMap;
    }

    /**
     * 退货入库的，增加可用销售库存
     */
    @Override
    public void updateSaleStockQuantity() {
        this.inventoryGoodsStockList.forEach(item -> {
            ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO = this.returnGoodsInputOrderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaleStockQuantity(item.getSaleStockQuantity() + returnGoodsInputOrderItemDTO.getArrivalCount());
            this.inventoryGoodsStockDAO.saveOrUpdate(item);
        });
    }

    /**
     * 减少已售库存
     */
    @Override
    public void updateSaledStockQuantity() {
        this.inventoryGoodsStockList.forEach(item -> {
            ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO = this.returnGoodsInputOrderItemDTOMap.get(item.getGoodsSkuId());
            item.setSaledStockQuantity(item.getSaledStockQuantity() - returnGoodsInputOrderItemDTO.getArrivalCount());
            this.inventoryGoodsStockDAO.saveOrUpdate(item);
        });
    }

    @Override
    public void updateLockedStockQuantity() {

    }
}
