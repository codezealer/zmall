package com.codezealer.zmall.inventory.command;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderItemDTO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;

import java.util.List;

public class PurchaseInputGoodsStockUpdateCommand extends AbstractGoodsStockUpdateCommand {

    List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOS;

    public PurchaseInputGoodsStockUpdateCommand(List<InventoryGoodsStock> inventoryGoodsStockList, InventoryGoodsStockDAO inventoryGoodsStockDAO, List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOS) {
        super(inventoryGoodsStockList, inventoryGoodsStockDAO);
        this.purchaseInputOrderItemDTOS = purchaseInputOrderItemDTOS;
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
