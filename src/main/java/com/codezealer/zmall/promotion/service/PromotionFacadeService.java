package com.codezealer.zmall.promotion.service;

import com.codezealer.zmall.promotion.entity.PromotionActivity;

import java.util.List;

/**
 * 促销中心对外提供接口
 */
public interface PromotionFacadeService {


    List<PromotionActivity> listActivitiesByGoodsSkuId(Long goodsSkuId);
}
