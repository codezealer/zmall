package com.codezealer.zmall.inventory.stock;

import com.codezealer.zmall.inventory.constant.StockStatus;
import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStockUpdaterFactory<T> implements StockUpdaterFactory<T> {

    protected InventoryGoodsStockDAO stockDAO;

    public AbstractStockUpdaterFactory(InventoryGoodsStockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @Override
    public StockUpdater create(T parameter) {
        List<Long> goodsSkuIds = getGoodsSkuIds(parameter);
        List<InventoryGoodsStock> goodsStocks = createGoodsStockDOs(goodsSkuIds);
        return create(goodsStocks, parameter);
    }

    protected abstract StockUpdater create(List<InventoryGoodsStock> goodsStocks, T parameter);

    private List<InventoryGoodsStock> createGoodsStockDOs(List<Long> goodsSkuIds) {
        List<InventoryGoodsStock> goodsStocks = new ArrayList<>();
        for (Long goodsSkuId : goodsSkuIds) {
            InventoryGoodsStock goodsStock = stockDAO.getByGoodsSkuId(goodsSkuId);
            if (goodsStock == null) {
                goodsStock = createGoodsStock(goodsSkuId);
                stockDAO.saveOrUpdate(goodsStock);
            }
        }
        return goodsStocks;
    }

    private InventoryGoodsStock createGoodsStock(Long goodsSkuId) {
        InventoryGoodsStock goodsStockDO = new InventoryGoodsStock();
        goodsStockDO.setGoodsSkuId(goodsSkuId);
        goodsStockDO.setSaleStockQuantity(0L);
        goodsStockDO.setLockedStockQuantity(0L);
        goodsStockDO.setSaledStockQuantity(0L);
        goodsStockDO.setStockStatus(StockStatus.OUT_STOCK);
        goodsStockDO.setGmtCreate(LocalDateTime.now());
        goodsStockDO.setGmtModified(LocalDateTime.now());
        return goodsStockDO;
    }

    protected abstract List<Long> getGoodsSkuIds(T parameter);


}
