package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderDTO;
import com.codezealer.zmall.wms.dto.ReturnGoodsInputOrderItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ReturnGoodsInputStockUpdaterFactory<T> extends AbstractStockUpdaterFactory<T> {

    public ReturnGoodsInputStockUpdaterFactory(InventoryGoodsStockDAO stockDAO) {
        super(stockDAO);
    }

    @Override
    protected StockUpdater create(List<InventoryGoodsStock> goodsStocks, T parameter) {
        ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO = (ReturnGoodsInputOrderDTO) parameter;
        List<ReturnGoodsInputOrderItemDTO> items = returnGoodsInputOrderDTO.getItems();
        Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap = items.stream().collect(Collectors.toMap(ReturnGoodsInputOrderItemDTO::getGoodsSkuId, Function.identity()));
        return new ReturnGoodsInputStockUpdater(goodsStocks, stockDAO, returnGoodsInputOrderItemDTOMap);
    }

    @Override
    protected List<Long> getGoodsSkuIds(T parameter) {
        ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO = (ReturnGoodsInputOrderDTO) parameter;
        List<ReturnGoodsInputOrderItemDTO> items = returnGoodsInputOrderDTO.getItems();
        return items.stream().map(ReturnGoodsInputOrderItemDTO::getGoodsSkuId).collect(Collectors.toList());
    }
}
