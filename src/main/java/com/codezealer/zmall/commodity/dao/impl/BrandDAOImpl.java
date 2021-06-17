package com.codezealer.zmall.commodity.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codezealer.zmall.commodity.dao.BrandDAO;
import com.codezealer.zmall.commodity.entity.CommodityBrand;
import com.codezealer.zmall.commodity.mapper.BrandMapper;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.common.page.PageRequest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BrandDAOImpl implements BrandDAO {
    @Resource
    BrandMapper brandMapper;

    @Override
    public Page<CommodityBrand> listByPage(PageRequest<BrandQuery> pageRequest) {
        BrandQuery query = pageRequest.getParam();
        Page<CommodityBrand> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        LambdaQueryWrapper<CommodityBrand> queryWrapper = createWrapper(query);
        return brandMapper.selectPage(page, queryWrapper);
    }

    @Override
    public CommodityBrand getById(Long id) {
        return brandMapper.selectById(id);
    }

    @Override
    public boolean insert(CommodityBrand commodityBrand) {
        return brandMapper.insert(commodityBrand) > 0;
    }

    @Override
    public boolean updateById(CommodityBrand commodityBrand) {
        return brandMapper.updateById(commodityBrand) > 0;
    }

    private LambdaQueryWrapper<CommodityBrand> createWrapper(BrandQuery query) {
        LambdaQueryWrapper<CommodityBrand> queryWrapper = Wrappers.lambdaQuery(CommodityBrand.class);
        if (StrUtil.isNotEmpty(query.getChineseName())) {
            queryWrapper.like(CommodityBrand::getBrandChineseName, query.getChineseName());
        }
        if (StrUtil.isNotEmpty(query.getEnglishName())) {
            queryWrapper.like(CommodityBrand::getBrandEnglishName, query.getEnglishName());
        }
        if (StrUtil.isNotEmpty(query.getAliasName())) {
            queryWrapper.like(CommodityBrand::getBrandAliasName, query.getAliasName());
        }
        return queryWrapper;
    }
}
