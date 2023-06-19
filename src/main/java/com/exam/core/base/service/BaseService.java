package com.exam.core.base.service;

import com.exam.core.base.dao.BaseDao;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.util.ClassFieldUtil;
import com.exam.core.common.util.GenericsUtils;
import lombok.Getter;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseService<T> {

    @Getter
    protected BaseDao<T> dao;


    /**
     * 默认批次提交数量
     */
    int DEFAULT_BATCH_SIZE = 1000;


    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    public T save(T entity) {
        try {
            return dao.insert(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T saveOrUpdate(T entity) {
        Map<String, Object> fields = ClassFieldUtil.getFields(entity);
        if (fields.containsKey(dao.getIdField())) {
            // 更新
            return dao.updateById(entity) > 0 ? entity : null;
        }
        // 新增
        try {
            return dao.insert(entity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     */
    public boolean saveBatch(Collection<T> entityList) {
        return saveBatch(entityList, DEFAULT_BATCH_SIZE);
    }

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        // TODO: 插入（批量）
        return false;
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     */
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        return saveOrUpdateBatch(entityList, DEFAULT_BATCH_SIZE);
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        // TODO: 批量修改插入
        return false;
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    public boolean removeById(Serializable id) {
        try {
            return dao.deleteById(id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据实体(ID)删除
     *
     * @param entity 实体
     * @since 3.4.4
     */
    public boolean removeById(T entity) {
        try {
            return dao.deleteById(entity) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     */
    public boolean removeByMap(Map<String, Object> columnMap) throws SQLException {
        return dao.deleteByMap(columnMap) > 0;
    }

    /**
     * 根据 entity 条件，删除记录
     */
    public boolean remove(Map<String, Object> queryWrapper) throws SQLException {
        return dao.deleteByMap(queryWrapper) > 0;
    }

    /**
     * 删除（根据ID 批量删除）
     *
     * @param list 主键ID或实体列表
     */
    public boolean removeByIds(Collection<?> list) throws SQLException {
        if (list.isEmpty()) {
            return false;
        }
        return dao.deleteBatchIds(list) == list.size();
    }


    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    public boolean updateById(T entity) {
        return dao.updateById(entity) > 0;
    }

    /**
     * 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     */
    public boolean update(Map<String, Object> updateWrapper) throws SQLException {
        return update(null, updateWrapper);
    }

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity 实体对象
     */
    public boolean update(T entity, Map<String, Object> updateWrapper) throws SQLException {
        return dao.update(entity, updateWrapper) > 0;
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     */
    public boolean updateBatchById(Collection<T> entityList) {
        return updateBatchById(entityList, DEFAULT_BATCH_SIZE);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        // TODO: 批量更新
        return false;
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    public T getById(Serializable id)  {
        return dao.selectById(id);
    }

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    public List<T> listByIds(Collection<? extends Serializable> idList) throws SQLException {
        return dao.selectBatchIds(idList);
    }

    /**
     * 查询（根据 columnMap 条件）
     *
     * @param columnMap 表字段 map 对象
     */
    public List<T> listByMap(Map<String, Object> columnMap) throws SQLException {
        return dao.selectByMap(columnMap);
    }

    /**
     * 根据 Wrapper，查询一条记录 <br/>
     * <p>结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")</p>
     */
    public T getOne(T entity) throws SQLException {
        return getOne(entity, true);
    }

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param throwEx 有多个 result 是否抛出异常
     */
    public T getOne(T entity, boolean throwEx) throws SQLException {
        return dao.selectOne(entity, throwEx);
    }

    /**
     * 查询总记录数
     */
    public long count() throws SQLException {
        return dao.selectCount(new HashMap<>());
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     */
    public long count(Map<String, Object> queryWrapper) {
        return dao.selectCount(queryWrapper);
    }

    /**
     * 查询列表
     */
    public List<T> list(Map<String, Object> queryWrapper) {
        try {
            return dao.selectByMap(queryWrapper);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有
     */
    public List<T> list() {
        return list(new HashMap<>());
    }

    /**
     * 翻页查询
     *
     * @param page 翻页对象
     */
    public <E extends IPage<T>> E page(E page, Map<String, Object> queryWrapper) {
        return dao.selectPage(page, queryWrapper);
    }

    /**
     * 无条件翻页查询
     *
     * @param page 翻页对象
     */
    public <E extends IPage<T>> E page(E page) {
        return page(page, new HashMap<>());
    }

    /**
     * 查询列表
     */
    public List<Map<String, Object>> listMaps(Map<String, Object> queryWrapper) throws SQLException {
        return dao.selectMaps(queryWrapper);
    }

    /**
     * 查询所有列表
     */
    public List<Map<String, Object>> listMaps() throws SQLException {
        return listMaps(new HashMap<>());
    }


    /**
     * 翻页查询
     *
     * @param page 翻页对象
     */
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Map<String, Object> queryWrapper) {
        return dao.selectMapsPage(page, queryWrapper);
    }

    /**
     * 无条件翻页查询
     *
     * @param page 翻页对象
     */
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return pageMaps(page, new HashMap<>());
    }

    /**
     * 获取 entity 的 class
     *
     * @return {@link Class<T>}
     */
    public Class<T> getEntityClass() {
        return GenericsUtils.getSuperClassGenericType(this.getClass());
    }

}
