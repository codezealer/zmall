package com.codezealer.zmall.purchase.service.impl;

import com.codezealer.zmall.purchase.entity.PurchaseOrderItem;
import com.codezealer.zmall.purchase.mapper.PurchaseOrderItemMapper;
import com.codezealer.zmall.purchase.service.PurchaseOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购单中的商品条目 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class PurchaseOrderItemServiceImpl extends ServiceImpl<PurchaseOrderItemMapper, PurchaseOrderItem> implements PurchaseOrderItemService {

}
