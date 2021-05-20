package com.codezealer.zmall.inventory.service;

import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;

/**
 * 库存中心对外提供接口u
 */
public interface InventoryFacadeService {

    /**
     * 采购入库更新库存
     */
    Boolean informPurchaseGoodsInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO);


    /**
     * 退货入库 更新库存
     */

    Boolean informReturnGoodsInputFinished();

}
