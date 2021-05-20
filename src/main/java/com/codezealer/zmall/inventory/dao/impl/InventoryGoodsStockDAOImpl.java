package com.codezealer.zmall.inventory.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.inventory.dao.InventoryGoodsStockDAO;
import com.codezealer.zmall.inventory.entity.InventoryGoodsStock;
import com.codezealer.zmall.inventory.mapper.InventoryGoodsStockMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class InventoryGoodsStockDAOImpl implements InventoryGoodsStockDAO {

    @Resource
    InventoryGoodsStockMapper inventoryGoodsStockMapper;

    @Override
    public InventoryGoodsStock getByGoodsSkuId(Long goodsSkuId) {
        return inventoryGoodsStockMapper.selectOne(new LambdaQueryWrapper<InventoryGoodsStock>().eq(InventoryGoodsStock::getGoodsSkuId, goodsSkuId));
    }

    @Override
    public void saveOrUpdate(InventoryGoodsStock inventoryGoodsStock) {
        if (inventoryGoodsStock.getId() != null) {
            inventoryGoodsStockMapper.updateById(inventoryGoodsStock);
        } else {
            inventoryGoodsStockMapper.insert(inventoryGoodsStock);
        }
    }
}
