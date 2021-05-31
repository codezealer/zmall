package com.codezealer.zmall.inventory.async;

import lombok.Data;

@Data
public class StockUpdateMessage <T> {

    private String messageId;
    private String operation;
    private T parameter;

}
