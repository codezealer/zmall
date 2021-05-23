package com.codezealer.zmall.inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseInputOrderDTO {

    Long purchaseOrderId;

    Long supplierId;


    List<PurchaseInputOrderItemDTO> itemList;

}
