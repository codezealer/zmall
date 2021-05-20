package com.codezealer.zmall.pay.service.impl;

import com.codezealer.zmall.pay.entity.PayTransaction;
import com.codezealer.zmall.pay.mapper.PayTransactionMapper;
import com.codezealer.zmall.pay.service.PayTransactionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付交易流水 服务实现类
 * </p>
 *
 * @author codezealer
 * @since 2021-05-20
 */
@Service
public class PayTransactionServiceImpl extends ServiceImpl<PayTransactionMapper, PayTransaction> implements PayTransactionService {

}
