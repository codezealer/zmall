package com.codezealer.zmall.inventory.async;

import lombok.Data;

@Data
public class StockUpdateMessage <T> {

    private String messageId;
    private Integer operation;
    private T parameter;

}
