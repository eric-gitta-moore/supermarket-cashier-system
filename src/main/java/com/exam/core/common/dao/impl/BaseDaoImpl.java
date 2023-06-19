package com.exam.core.common.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.exam.core.common.dao.BaseDao;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.util.ClassFieldUtil;
import com.exam.core.common.util.GenericsUtils;
import com.exam.core.common.util.SqlUtil;
import com.exam.supermarket.util.DbPoolUtil;
import lombok.Getter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @Getter
    protected String table;

    @Getter
    protected String idField = "id";

    @Getter
    private QueryRunner runner;

    public BaseDaoImpl() {
        this.runner = DbPoolUtil.getRunner();
    }

    @Override
    public T insert(T entity) throws SQLException {
        Map<String, Object> entityFieldMap = ClassFieldUtil.getFields(entity);
        entityFieldMap.remove(this.idField);
        String sql = String.format("insert into %s (%s) values (%s)",
            this.table,
            String.join(",", entityFieldMap.keySet()),
            String.join(",", entityFieldMap.values().stream().map(e -> "?").toList()));

        Class<T> tClass = GenericsUtils.getSuperClassGenericType(this.getClass());
        return runner.insert(sql, new BeanHandler<>(tClass), entityFieldMap.values().toArray());
    }

    @Override
    public int deleteById(Serializable id) throws SQLException {
        return this.deleteBatchIds(Arrays.asList(id));
    }

    @Override
    public int deleteById(T entity) throws SQLException {
        Map<String, Object> entityFieldMap = ClassFieldUtil.getFields(entity);
        return this.deleteBatchIds(Arrays.asList(entityFieldMap.get(this.idField)));
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) throws SQLException {
        if (columnMap == null || columnMap.isEmpty()) {
            return 0;
        }
        String sql = String.format("delete from %s where 1=1", this.table);
        sql = SqlUtil.concatWhere(sql, columnMap);
        return this.runner.update(sql, columnMap.values().toArray());
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) throws SQLException {
        List<String> ids = idList.stream().map(String::valueOf).toList();
        String sql = String.format("delete from %s where %s in (%s)",
            this.table,
            this.idField,
            String.join(",", ids.stream().map(e -> "?").toList()));
        return runner.update(sql, ids.toArray());
    }

    @Override
    public int updateById(T entity) {
        return update(entity, new HashMap<>());
    }

    @Override
    public int update(T entity, Map<String, Object> columnMap) {
        Object id;
        Map<String, Object> entityFieldMap = ClassFieldUtil.getFields(entity);
        if (columnMap.containsKey(this.idField)) {
            id = columnMap.get(this.idField);
        } else {
            id = entityFieldMap.get(this.idField);
        }
        entityFieldMap.remove(this.idField);
        List<String> setSql = entityFieldMap.entrySet().stream().map(e -> e.getKey() + "=?").toList();
        String sql = String.format("update %s set %s where %s=?",
            this.table,
            String.join(",", setSql),
            this.idField);
        List<Object> params = new ArrayList<>(entityFieldMap.values());
        params.add(id);
        try {
            return this.runner.update(sql, params.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T selectById(Serializable id) {
        String sql = "select * from " + this.table + " where " + this.idField + "=?";
        Class<T> tClass = GenericsUtils.getSuperClassGenericType(this.getClass());
        T poList = null;
        try {
            poList = runner.query(sql, new BeanHandler<>(tClass), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return poList;
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) throws SQLException {
        String sql = "select * from " + this.table + " where 1=1";
        List<String> ids = idList.stream().map(e -> e.toString()).collect(Collectors.toList());
        sql += " and " + this.idField + " in (" + String.join(",", ids) + ")";
        Class<T> tClass = GenericsUtils.getSuperClassGenericType(this.getClass());
        List<T> poList = runner.query(sql, new BeanListHandler<>(tClass));
        return poList;
    }

    @Override
    public List<T> selectByMap(Map<String, Object> columnMap) throws SQLException {
        String sql = "select * from " + this.table + " where 1=1";
        sql = SqlUtil.concatWhere(sql, columnMap);
        Class<T> tClass = GenericsUtils.getSuperClassGenericType(this.getClass());
        Object[] params = columnMap.values().toArray();
        List<T> poList = runner.query(sql, new BeanListHandler<>(tClass), params);
        return poList;
    }

    @Override
    public T selectOne(T entity, boolean throwEx) {
        try {
            return BaseDao.super.selectOne(entity, throwEx);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(Map<String, Object> columnMap) {
        try {
            return BaseDao.super.exists(columnMap);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long selectCount(Map<String, Object> columnMap) {
        String sql = "select count(1) from " + this.table + " where 1=1";
        sql = SqlUtil.concatWhere(sql, columnMap);
        Object[] params = columnMap.values().toArray();
        Long cnt = null;
        try {
            cnt = runner.query(sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

    @Override
    public List<T> selectList(T entity) throws SQLException {
        Map<String, Object> queryParam = ClassFieldUtil.getFields(entity);
        return this.selectByMap(queryParam);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Map<String, Object> columnMap) throws SQLException {
        String sql = "select * from " + this.table + " where 1=1";
        sql = SqlUtil.concatWhere(sql, columnMap);
        Object[] params = columnMap.values().toArray();
        List<Map<String, Object>> poList = runner.query(sql, new MapListHandler(), params);
        return poList;
    }

    @Override
    public <P extends IPage<T>> P selectPage(P page, Map<String, Object> columnMap) {
        page.setTotal(this.selectCount(columnMap));

        String sql = String.format("select * from %s where 1=1", this.table);
        sql = SqlUtil.concatWhere(sql, columnMap);
        sql += " limit " + page.offset() + "," + page.getSize();
        Class<T> tClass = GenericsUtils.getSuperClassGenericType(this.getClass());
        List<T> poList = null;
        try {
            poList = runner.query(sql, new BeanListHandler<>(tClass));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        page.setRecords(poList);
        return page;
    }

    @Override
    public <P extends IPage<T>> P selectPage(P page) {
        return selectPage(page, new HashMap<>());
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Map<String, Object> columnMap) {
        page.setTotal(this.selectCount(columnMap));

        String sql = String.format("select * from %s where 1=1", this.table);
        sql = SqlUtil.concatWhere(sql, columnMap);
        sql += " limit " + page.offset() + "," + page.getSize();
        List<Map<String, Object>> poList = null;
        try {
            poList = runner.query(sql, new MapListHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        page.setRecords(poList);
        return page;
    }
}
