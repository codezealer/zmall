package com.codezealer.zmall.cart.dto;

import com.codezealer.zmall.cart.entity.ShoppingCartItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShoppingCartDTO {

    private Long id;

    /**
     * 会员账号ID
     */
    private Long userAccountId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 购物车项
     */
    List<ShoppingCartItemDTO> shoppingCartItemList;
}
