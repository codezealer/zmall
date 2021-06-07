package com.codezealer.zmall.common.page;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private long pageNum;

    private long pageSize;

    private long totalSize;

    private long totalPages;

    private List<T> pageList;

}
