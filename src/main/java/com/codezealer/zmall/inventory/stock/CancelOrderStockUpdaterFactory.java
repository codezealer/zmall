package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.order.dto.OrderInfoDTO;
import com.codezealer.zmall.order.dto.OrderItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CancelOrderStockUpdaterFactory<T> extends AbstractStockUpdaterFactory<T> {

    public CancelOrderStockUpdaterFactory(InventoryGoodsStockDAO stockDAO) {
        super(stockDAO);
    }

    @Override
    protected StockUpdater create(List<InventoryGoodsStock> goodsStocks, T parameter) {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) parameter;
        Map<Long, OrderItemDTO> orderItemDTOMap = orderInfoDTO.getOrderItems().stream().collect(Collectors.toMap(OrderItemDTO::getGoodsSkuId, Function.identity()));
        return new PayOrderStockUpdater(goodsStocks, this.stockDAO, orderItemDTOMap);
    }

    @Override
    protected List<Long> getGoodsSkuIds(T parameter) {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) parameter;
        List<OrderItemDTO> orderItems = orderInfoDTO.getOrderItems();
        return orderItems.stream().map(OrderItemDTO::getGoodsSkuId).collect(Collectors.toList());
    }
}
