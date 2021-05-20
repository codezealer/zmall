package com.codezealer.zmall.promotion.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codezealer.zmall.promotion.dao.PromotionActivityDAO;
import com.codezealer.zmall.promotion.entity.PromotionActivity;
import com.codezealer.zmall.promotion.mapper.PromotionActivityMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class PromotionActivityDAOImpl implements PromotionActivityDAO {

    @Resource
    PromotionActivityMapper promotionActivityMapper;


    @Override
    public List<PromotionActivity> selectList(List<Long> activityIdList) {
        return promotionActivityMapper.selectList(new LambdaQueryWrapper<PromotionActivity>().in(PromotionActivity::getId, activityIdList));
    }
}
