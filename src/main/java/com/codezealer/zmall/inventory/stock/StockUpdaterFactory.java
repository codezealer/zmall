package com.codezealer.zmall.inventory.stock;

public interface StockUpdaterFactory<T> {

    StockUpdater create(T parameter);

}
