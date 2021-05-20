package com.codezealer.zmall.promotion.dao;

import com.codezealer.zmall.promotion.entity.PromotionActivityGoodsSkuRelationship;

import java.util.List;

public interface PromotionActivityGoodsSkuRelationshipDAO {
    List<PromotionActivityGoodsSkuRelationship> selectByGoodsId(Long goodsSkuId);
}
