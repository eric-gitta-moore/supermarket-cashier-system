package com.exam.core.common.plugin.pagination;

import com.exam.core.common.metadata.IPage;
import com.exam.core.common.metadata.OrderItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Page<T> implements IPage<T> {

    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    @Getter
    protected List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    @Getter
    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    @Getter
    protected long size = 10;

    /**
     * 当前页
     */
    @Getter
    protected long current = 1;

    /**
     * 排序字段信息
     */
    @Setter
    @Getter
    protected List<OrderItem> orders = new ArrayList<>();

    /**
     * 是否进行 count 查询
     */
    protected boolean searchCount = true;

    /**
     * 单页分页条数限制
     */
    @Setter
    @Getter
    protected Long maxLimit;
    /**
     * countId
     */
    @Setter
    @Getter
    protected String countId;

    @Override
    public IPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public IPage<T> setSize(long size) {
        this.size = size;
        return this;
    }

    public Page() {
    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public Page(long current, long size) {
        this(current, size, 0);
    }

    public Page(long current, long size, long total) {
        this(current, size, total, true);
    }

    public Page(long current, long size, boolean searchCount) {
        this(current, size, 0, searchCount);
    }

    public Page(long current, long size, long total, boolean searchCount) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.total = total;
        this.searchCount = searchCount;
    }

    /**
     * 是否存在上一页
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * 是否存在下一页
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    /* --------------- 以下为静态构造方式 --------------- */
    public static <T> Page<T> of(long current, long size) {
        return of(current, size, 0);
    }

    public static <T> Page<T> of(long current, long size, long total) {
        return of(current, size, total, true);
    }

    public static <T> Page<T> of(long current, long size, boolean searchCount) {
        return of(current, size, 0, searchCount);
    }

    public static <T> Page<T> of(long current, long size, long total, boolean searchCount) {
        return new Page<>(current, size, total, searchCount);
    }

    @Override
    public List<OrderItem> orders() {
        return this.getOrders();
    }

    @Override
    public boolean searchCount() {
        return IPage.super.searchCount();
    }

    @Override
    public long offset() {
        return IPage.super.offset();
    }

    @Override
    public Long maxLimit() {
        return IPage.super.maxLimit();
    }

    @Override
    public long getPages() {
        return IPage.super.getPages();
    }

    @Override
    public IPage<T> setPages(long pages) {
        return IPage.super.setPages(pages);
    }

    @Override
    public <R> IPage<R> convert(Function<? super T, ? extends R> mapper) {
        return IPage.super.convert(mapper);
    }
}
