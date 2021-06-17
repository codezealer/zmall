package com.codezealer.zmall.commodity.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codezealer.zmall.commodity.entity.CommodityBrand;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;

public interface BrandDAO {
    Page<CommodityBrand> listByPage(PageRequest<BrandQuery> pageRequest);

    CommodityBrand getById(Long id);

    boolean insert(CommodityBrand commodityBrand);

    boolean updateById(CommodityBrand commodityBrand);
}
