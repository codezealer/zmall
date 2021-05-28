package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderDTO;
import com.codezealer.zmall.inventory.dto.PurchaseInputOrderItemDTO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PurchaseInputStockUpdaterFactory<T> extends AbstractStockUpdaterFactory<T> {

    public PurchaseInputStockUpdaterFactory(InventoryGoodsStockDAO stockDAO) {
        super(stockDAO);
    }

    @Override
    protected StockUpdater create(List<InventoryGoodsStock> goodsStocks, T parameter) {
        PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
        List<PurchaseInputOrderItemDTO> itemList = purchaseInputOrderDTO.getItemList();
        Map<Long, PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOMap = itemList.stream().collect(Collectors.toMap(PurchaseInputOrderItemDTO::getGoodsSkuId, Function.identity()));
        return new PurchaseInputStockUpdater(goodsStocks, this.stockDAO, purchaseInputOrderItemDTOMap);
    }

    @Override
    protected List<Long> getGoodsSkuIds(T parameter) {
        PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
        List<PurchaseInputOrderItemDTO> itemList = purchaseInputOrderDTO.getItemList();
        return itemList.stream().map(PurchaseInputOrderItemDTO::getGoodsSkuId).collect(Collectors.toList());
    }
}
