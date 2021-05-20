package com.codezealer.zmall.promotion.service.impl;

import com.codezealer.zmall.promotion.dao.PromotionActivityDAO;
import com.codezealer.zmall.promotion.dao.PromotionActivityGoodsSkuRelationshipDAO;
import com.codezealer.zmall.promotion.entity.PromotionActivity;
import com.codezealer.zmall.promotion.entity.PromotionActivityGoodsSkuRelationship;
import com.codezealer.zmall.promotion.service.PromotionFacadeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionFacadeServiceImpl implements PromotionFacadeService {

    @Resource
    PromotionActivityDAO promotionActivityDAO;
    @Resource
    PromotionActivityGoodsSkuRelationshipDAO promotionActivityGoodsSkuRelationshipDAO;

    @Override
    public List<PromotionActivity> listActivitiesByGoodsSkuId(Long goodsSkuId) {
        List<PromotionActivityGoodsSkuRelationship> relationships = promotionActivityGoodsSkuRelationshipDAO.selectByGoodsId(goodsSkuId);
        final List<Long> activityIdList = relationships.stream().map(PromotionActivityGoodsSkuRelationship::getPromotionActivityId).collect(Collectors.toList());
        List<PromotionActivity> activityList = promotionActivityDAO.selectList(activityIdList);
        return null;
    }
}
