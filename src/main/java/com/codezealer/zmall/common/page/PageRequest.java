package com.codezealer.zmall.common.page;

import lombok.Data;

@Data
public class PageRequest<T> {

    /**
     * 查询的页码
     */
    private long pageNum = 1L;

    /**
     * 每页个数
     */
    private long pageSize = 10L;

    /**
     * 参数
     */
    private T param;


}
