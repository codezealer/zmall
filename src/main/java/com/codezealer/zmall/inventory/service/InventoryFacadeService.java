package com.codezealer.zmall.inventory.service;

import com.codezealer.zmall.inventory.dto.OrderInfoDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderDTO;

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
    Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 提交订单 更新库存
     * @param orderInfoDTO
     * @return
     */
    Boolean informSubmitOrderEvent(OrderInfoDTO orderInfoDTO);
}
