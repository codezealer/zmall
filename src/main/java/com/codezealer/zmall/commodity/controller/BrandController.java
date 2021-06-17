package com.codezealer.zmall.commodity.controller;


import cn.hutool.core.bean.BeanUtil;
import com.codezealer.zmall.commodity.dto.BrandDTO;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.commodity.service.BrandService;
import com.codezealer.zmall.commodity.vo.BrandVO;
import com.codezealer.zmall.common.http.HttpResult;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class BrandController {

    @Resource
    BrandService brandService;

    @RequestMapping("/page")
    public HttpResult<PageResult<BrandDTO>> listPage(PageRequest<BrandQuery> pageRequest) {
        PageResult<BrandDTO> pageResult = brandService.listPage(pageRequest);
        return HttpResult.ok(pageResult);
    }

    @RequestMapping("/{id}")
    public HttpResult<BrandDTO> get(@PathVariable("id") Long id) {
        return HttpResult.ok(brandService.getById(id));
    }

    @RequestMapping("/add")
    public HttpResult<Boolean> add(@RequestBody BrandVO brandVO) {
        BrandDTO brandDTO = BeanUtil.copyProperties(brandVO, BrandDTO.class);
        return brandService.add(brandDTO) ? HttpResult.ok() : HttpResult.error();
    }
    @RequestMapping("/update")
    public HttpResult<Boolean> update(@RequestBody BrandVO brandVO) {
        BrandDTO brandDTO = BeanUtil.copyProperties(brandVO, BrandDTO.class);
        return brandService.update(brandDTO) ? HttpResult.ok() : HttpResult.error();
    }

}

