package com.codezealer.zmall.commodity.service.impl;

import com.codezealer.zmall.commodity.dao.BrandDAO;
import com.codezealer.zmall.commodity.dto.BrandDTO;
import com.codezealer.zmall.commodity.entity.CommodityBrand;
import com.codezealer.zmall.commodity.mapper.CommodityBrandMapper;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.commodity.service.CommodityBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商品中心的品牌表 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class CommodityBrandServiceImpl extends ServiceImpl<CommodityBrandMapper, CommodityBrand> implements CommodityBrandService {

    @Resource
    BrandDAO brandDAO;

    @Override
    public PageResult<BrandDTO> listPage(PageRequest<BrandQuery> pageRequest) {

        return null;
    }
}
