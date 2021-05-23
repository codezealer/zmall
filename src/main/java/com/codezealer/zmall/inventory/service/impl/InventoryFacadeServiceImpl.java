package com.codezealer.zmall.inventory.service.impl;

import com.codezealer.zmall.inventory.constant.StockStatus;
import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderItemDTO;
import com.codezealer.zmall.inventory.dto.ReturnGoodsInputDTO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.inventory.service.InventoryFacadeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryFacadeServiceImpl implements InventoryFacadeService {
    @Resource
    InventoryGoodsStockDAO inventoryGoodsStockDAO;

    /**
     * 采购入库更新库存：
     * 更新销售库存
     * 更新锁定库存
     * 更新已售库存
     * 更新库存状态
     * 更新时间
     *
     * @param purchaseInputOrderDTO
     * @return
     */
    @Override
    public Boolean informPurchaseGoodsInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO) {
        List<PurchaseInputOrderItemDTO> itemList = purchaseInputOrderDTO.getItemList();
        for (PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : itemList) {
            InventoryGoodsStock inventoryGoodsStock = inventoryGoodsStockDAO.getByGoodsSkuId(purchaseInputOrderItemDTO.getGoodsSkuId());
            if (inventoryGoodsStock == null) {
                inventoryGoodsStock = new InventoryGoodsStock();
                inventoryGoodsStock.setGoodsSkuId(purchaseInputOrderItemDTO.getGoodsSkuId());
                inventoryGoodsStock.setStockStatus(StockStatus.OUT_STOCK);
                inventoryGoodsStock.setSaledStockQuantity(0L);
                inventoryGoodsStock.setLockedStockQuantity(0L);
                inventoryGoodsStock.setSaleStockQuantity(0L);
                inventoryGoodsStock.setGmtCreate(LocalDateTime.now());
                inventoryGoodsStock.setGmtModified(LocalDateTime.now());
            }

            inventoryGoodsStock.setSaleStockQuantity(inventoryGoodsStock.getSaleStockQuantity() + purchaseInputOrderItemDTO.getPurchaseCount());
            inventoryGoodsStock.setStockStatus(inventoryGoodsStock.getSaleStockQuantity() > 0 ? StockStatus.IN_STOCK : StockStatus.OUT_STOCK);
            inventoryGoodsStock.setGmtModified(LocalDateTime.now());
            inventoryGoodsStockDAO.saveOrUpdate(inventoryGoodsStock);
        }

        return true;
    }

    /**
     * 退货入库
     * @param returnGoodsInputDTO
     * @return
     */
    @Override
    public Boolean informReturnGoodsInputFinished(ReturnGoodsInputDTO returnGoodsInputDTO) {
        InventoryGoodsStock inventoryGoodsStock = inventoryGoodsStockDAO.getByGoodsSkuId(returnGoodsInputDTO.getGoodsSkuId());
        if (inventoryGoodsStock == null) {
            inventoryGoodsStock = new InventoryGoodsStock();
            inventoryGoodsStock.setGoodsSkuId(returnGoodsInputDTO.getGoodsSkuId());
            inventoryGoodsStock.setStockStatus(StockStatus.OUT_STOCK);
            inventoryGoodsStock.setSaledStockQuantity(0L);
            inventoryGoodsStock.setLockedStockQuantity(0L);
            inventoryGoodsStock.setSaleStockQuantity(0L);
            inventoryGoodsStock.setGmtCreate(LocalDateTime.now());
            inventoryGoodsStock.setGmtModified(LocalDateTime.now());
        }
        inventoryGoodsStock.setSaleStockQuantity(inventoryGoodsStock.getSaleStockQuantity() + returnGoodsInputDTO.getReturnCount());
        inventoryGoodsStock.setSaledStockQuantity(inventoryGoodsStock.getSaledStockQuantity() - returnGoodsInputDTO.getReturnCount());
        inventoryGoodsStock.setStockStatus(inventoryGoodsStock.getSaleStockQuantity() > 0 ? StockStatus.IN_STOCK : StockStatus.OUT_STOCK);
        inventoryGoodsStock.setGmtModified(LocalDateTime.now());
        inventoryGoodsStockDAO.saveOrUpdate(inventoryGoodsStock);
        return true;
    }
}
