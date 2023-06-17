package com.exam.core.common.dao.impl;

import com.exam.core.common.dao.BaseDao;
import com.exam.core.common.metadata.IPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements BaseDao<T> {

    protected String table = null;
    protected String idField = "id";


    @Override
    public int insert(T entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteById(T entity) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<?> idList) {
        return 0;
    }

    @Override
    public int updateById(T entity) {
        return 0;
    }

    @Override
    public int update(T entity, Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public T selectById(Serializable id) {
        return null;
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<T> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public T selectOne(Map<String, Object> columnMap, boolean throwEx) {
        return BaseDao.super.selectOne(columnMap, throwEx);
    }

    @Override
    public boolean exists(Map<String, Object> columnMap) {
        return BaseDao.super.exists(columnMap);
    }

    @Override
    public Long selectCount(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public List<T> selectList(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public <P extends IPage<T>> P selectPage(P page, Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Map<String, Object> columnMap) {
        return null;
    }
}
