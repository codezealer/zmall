package com.codezealer.zmall.commodity.service;

import com.codezealer.zmall.commodity.dto.BrandDTO;
import com.codezealer.zmall.commodity.entity.CommodityBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;

/**
 * <p>
 * 商品中心的品牌表 服务类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
public interface CommodityBrandService extends IService<CommodityBrand> {

    PageResult<BrandDTO> listPage(PageRequest<BrandQuery> pageRequest);
}
