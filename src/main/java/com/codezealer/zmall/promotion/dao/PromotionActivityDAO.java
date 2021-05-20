package com.codezealer.zmall.promotion.dao;

import com.codezealer.zmall.promotion.entity.PromotionActivity;

import java.util.List;

public interface PromotionActivityDAO {

    List<PromotionActivity> selectList(List<Long> activityIdList);
}
