package com.codezealer.zmall.cart.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codezealer.zmall.cart.dao.ShoppingCartDAO;
import com.codezealer.zmall.cart.dao.ShoppingCartItemDAO;
import com.codezealer.zmall.cart.dto.ShoppingCartDTO;
import com.codezealer.zmall.cart.dto.ShoppingCartItemDTO;
import com.codezealer.zmall.cart.entity.ShoppingCart;
import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import com.codezealer.zmall.cart.mapper.ShoppingCartItemMapper;
import com.codezealer.zmall.cart.mapper.ShoppingCartMapper;
import com.codezealer.zmall.cart.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codezealer.zmall.promotion.entity.PromotionActivity;
import com.codezealer.zmall.promotion.service.PromotionActivityService;
import com.codezealer.zmall.promotion.service.PromotionFacadeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

    @Resource
    ShoppingCartDAO shoppingCartDAO;

    @Resource
    ShoppingCartItemDAO shoppingCartITemDAO;

    @Resource
    PromotionFacadeService promotionFacadeService;


    @Override
    public Boolean addShoppingCartItem(ShoppingCartItemDTO shoppingCartItemDTO) {
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByAccountId(shoppingCartItemDTO.getUserAccountId());
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserAccountId(shoppingCartItemDTO.getUserAccountId());
            shoppingCart.setGmtCreate(LocalDateTime.now());
            shoppingCart.setGmtModified(LocalDateTime.now());
            shoppingCartDAO.addShoppingCart(shoppingCart);
        }
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        BeanUtil.copyProperties(shoppingCartItemDTO, shoppingCartItem);
        shoppingCartItem.setShoppingCartId(shoppingCart.getId());
        shoppingCartItem.setGmtCreate(LocalDateTime.now());
        shoppingCartItem.setGmtModified(LocalDateTime.now());
        shoppingCartITemDAO.save(shoppingCartItem);
        return true;
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long accountId) {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByAccountId(accountId);
        BeanUtil.copyProperties(shoppingCart, shoppingCartDTO);
        List<ShoppingCartItem> itemList = shoppingCartITemDAO.queryListByShoppingCartId(shoppingCart.getId());
        List<ShoppingCartItemDTO> shoppingCartItemDTOs = new ArrayList<>(itemList.size());

        for (ShoppingCartItem shoppingCartItem : itemList) {
            ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
            BeanUtil.copyProperties(shoppingCartItem, shoppingCartItemDTO);

            List<PromotionActivity> promotionActivityList = promotionFacadeService.listActivitiesByGoodsSkuId(shoppingCartItemDTO.getGoodsSkuId());
            shoppingCartItemDTO.setPromotionActivityList(promotionActivityList);
        }
        return shoppingCartDTO;

    }
}
