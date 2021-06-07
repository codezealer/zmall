package com.codezealer.zmall.commodity.controller;


import com.codezealer.zmall.commodity.dto.BrandDTO;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.commodity.service.CommodityBrandService;
import com.codezealer.zmall.common.http.HttpResult;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品中心的品牌表 前端控制器
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@RestController
@RequestMapping("/commodity/brand")
public class CommodityBrandController {

    @Resource
    CommodityBrandService brandService;

    @RequestMapping("/page")
    public HttpResult<PageResult<BrandDTO>> listPage(PageRequest<BrandQuery> pageRequest) {
        PageResult<BrandDTO> pageResult = brandService.listPage(pageRequest);
        return HttpResult.ok(pageResult);
    }

}

