package com.codezealer.zmall.inventory.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

@Slf4j
@Component
public class StockUpdateObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        StockUpdateResult result = (StockUpdateResult) arg;
        log.info("商品库存更新消息[messageId=" + result.getMessageId() + "]"
                + "的异步处理结果为：" + result.getResult());
    }
}
