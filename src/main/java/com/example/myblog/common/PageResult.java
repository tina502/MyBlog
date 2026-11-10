package com.example.myblog.common;

import java.util.List;

/**
 * Week07：一页数据的形状。items 是这一页的记录，total 是"命中总数"，不是这一页的条数。
 */
public class PageResult<T> {

    private List<T> items;
    private long total;
    private long page;
    private long size;

    public PageResult(List<T> items, long total, long page, long size) {
        this.items = items;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public List<T> getItems() {
        return items;
    }

    public long getTotal() {
        return total;
    }

    public long getPage() {
        return page;
    }

    public long getSize() {
        return size;
    }
}
