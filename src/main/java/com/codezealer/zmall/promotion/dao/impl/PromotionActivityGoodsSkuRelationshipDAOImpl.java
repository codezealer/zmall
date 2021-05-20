package com.codezealer.zmall.promotion.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.promotion.dao.PromotionActivityGoodsSkuRelationshipDAO;
import com.codezealer.zmall.promotion.entity.PromotionActivityGoodsSkuRelationship;
import com.codezealer.zmall.promotion.mapper.PromotionActivityGoodsSkuRelationshipMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PromotionActivityGoodsSkuRelationshipDAOImpl implements PromotionActivityGoodsSkuRelationshipDAO {

    @Resource
    PromotionActivityGoodsSkuRelationshipMapper promotionActivityGoodsSkuRelationshipMapper;

    @Override
    public List<PromotionActivityGoodsSkuRelationship> selectByGoodsId(Long goodsSkuId) {
        return promotionActivityGoodsSkuRelationshipMapper.selectList(new LambdaQueryWrapper<PromotionActivityGoodsSkuRelationship>().eq(PromotionActivityGoodsSkuRelationship::getGoodsId, goodsSkuId));
    }
}
