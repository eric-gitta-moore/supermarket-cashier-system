package com.curtis.core.common.plugin.pagination;

import com.curtis.core.common.metadata.IPage;
import com.curtis.core.common.metadata.OrderItem;
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
    protected List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    protected long size = 10;

    /**
     * 当前页
     */
    protected long current = 1;

    /**
     * 排序字段信息
     */
    @Setter
    protected List<OrderItem> orders = new ArrayList<>();

    /**
     * 自动优化 COUNT SQL
     */
    protected boolean optimizeCountSql = true;
    /**
     * 是否进行 count 查询
     */
    protected boolean searchCount = true;
    /**
     * {@link #optimizeJoinOfCountSql()}
     */
    @Setter
    protected boolean optimizeJoinOfCountSql = true;
    /**
     * 单页分页条数限制
     */
    @Setter
    protected Long maxLimit;
    /**
     * countId
     */
    @Setter
    protected String countId;

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
        return null;
    }

    @Override
    public boolean optimizeCountSql() {
        return IPage.super.optimizeCountSql();
    }

    @Override
    public boolean optimizeJoinOfCountSql() {
        return IPage.super.optimizeJoinOfCountSql();
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
    public List<T> getRecords() {
        return null;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        return null;
    }

    @Override
    public long getTotal() {
        return 0;
    }

    @Override
    public IPage<T> setTotal(long total) {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public IPage<T> setSize(long size) {
        return null;
    }

    @Override
    public long getCurrent() {
        return 0;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        return null;
    }

    @Override
    public <R> IPage<R> convert(Function<? super T, ? extends R> mapper) {
        return IPage.super.convert(mapper);
    }
}
