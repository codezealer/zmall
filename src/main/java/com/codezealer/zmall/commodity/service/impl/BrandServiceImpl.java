package com.codezealer.zmall.commodity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codezealer.zmall.comment.dto.CommentInfoDTO;
import com.codezealer.zmall.comment.entity.CommentInfo;
import com.codezealer.zmall.commodity.dao.BrandDAO;
import com.codezealer.zmall.commodity.dto.BrandDTO;
import com.codezealer.zmall.commodity.entity.CommodityBrand;
import com.codezealer.zmall.commodity.query.BrandQuery;
import com.codezealer.zmall.commodity.service.BrandService;
import com.codezealer.zmall.common.page.PageRequest;
import com.codezealer.zmall.common.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品中心的品牌表 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    BrandDAO brandDAO;

    @Override
    public PageResult<BrandDTO> listPage(PageRequest<BrandQuery> pageRequest) {
        Page<CommodityBrand> brandPage = brandDAO.listByPage(pageRequest);
        PageResult<BrandDTO> pageResult = new PageResult<>();
        pageResult.setPageNum(brandPage.getCurrent());
        pageResult.setPageSize(brandPage.getSize());
        pageResult.setTotalPages(brandPage.getPages());
        pageResult.setTotalSize(brandPage.getTotal());
        List<CommodityBrand> records = brandPage.getRecords();
        List<BrandDTO> brandDTOs = BeanUtil.copyToList(records, BrandDTO.class, null);
        pageResult.setPageList(brandDTOs);
        return pageResult;
    }

    @Override
    public BrandDTO getById(Long id) {
        CommodityBrand brand = brandDAO.getById(id);
        return BeanUtil.copyProperties(brand, BrandDTO.class);
    }

    @Override
    public boolean add(BrandDTO brandDTO) {
        CommodityBrand commodityBrand = BeanUtil.copyProperties(brandDTO, CommodityBrand.class);
        return brandDAO.insert(commodityBrand);
    }

    @Override
    public boolean update(BrandDTO brandDTO) {
        CommodityBrand commodityBrand = BeanUtil.copyProperties(brandDTO, CommodityBrand.class);
        return brandDAO.updateById(commodityBrand);
    }
}
