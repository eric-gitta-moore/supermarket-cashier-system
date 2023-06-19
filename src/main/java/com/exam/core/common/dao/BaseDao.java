package com.exam.core.common.dao;

import com.exam.core.common.exception.TooManyResultsException;
import com.exam.core.common.metadata.IPage;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     */
    T insert(T entity) throws SQLException;

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    int deleteById(Serializable id) throws SQLException;

    /**
     * 根据实体(ID)删除
     *
     * @param entity 实体对象
     * @since 3.4.4
     */
    int deleteById(T entity) throws SQLException;

    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     */
    int deleteByMap(Map<String, Object> columnMap) throws SQLException;

    /**
     * 删除（根据ID或实体 批量删除）
     *
     * @param idList 主键ID列表或实体列表(不能为 null 以及 empty)
     */
    int deleteBatchIds(Collection<?> idList) throws SQLException;

    /**
     * 根据 ID 修改
     *
     * @param entity 实体对象
     */
    int updateById(T entity) throws SQLException;

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity    实体对象 (set 条件值,可以为 null)
     * @param columnMap 表字段 map 对象（可以为 null,里面的 entity 用于生成 where 语句）
     */
    int update(T entity, Map<String, Object> columnMap) throws SQLException;

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    T selectById(Serializable id) throws SQLException;

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    List<T> selectBatchIds(Collection<? extends Serializable> idList) throws SQLException;

    Map<String, T> selectKeyedBatchIds(Collection<? extends Serializable> idList) throws SQLException;

    /**
     * 查询（根据 columnMap 条件）
     *
     * @param columnMap 表字段 map 对象
     */
    List<T> selectByMap(Map<String, Object> columnMap) throws SQLException;

    /**
     * 根据 entity 条件，查询一条记录，现在会根据{@code throwEx}参数判断是否抛出异常，如果为false就直接返回一条数据
     * <p>查询一条记录，例如 qw.last("limit 1") 限制取一条记录, 注意：多条数据会报异常</p>
     *
     * @param throwEx boolean 参数，为true如果存在多个结果直接抛出异常
     */
    default T selectOne(T entity, boolean throwEx) throws SQLException {
        List<T> list = this.selectList(entity);
        // 抄自 DefaultSqlSession#selectOne
        int size = list.size();
        if (size == 1) {
            return list.get(0);
        } else if (size > 1) {
            if (throwEx) {
                throw new TooManyResultsException(
                    "Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
            }
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据 Wrapper 条件，判断是否存在记录
     *
     * @param columnMap 表字段 map 对象
     * @return 是否存在记录
     */
    default boolean exists(Map<String, Object> columnMap) throws SQLException {
        Long count = this.selectCount(columnMap);
        return null != count && count > 0;
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     *
     * @param columnMap 表字段 map 对象
     */
    Long selectCount(Map<String, Object> columnMap) throws SQLException;

    /**
     * 根据 entity 条件，查询全部记录
     */
    List<T> selectList(T entity) throws SQLException;

    /**
     * 根据 Wrapper 条件，查询全部记录
     *
     * @param columnMap 表字段 map 对象
     */
    List<Map<String, Object>> selectMaps(Map<String, Object> columnMap) throws SQLException;

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param page      分页查询条件（可以为 RowBounds.DEFAULT）
     * @param columnMap 表字段 map 对象
     */
    <P extends IPage<T>> P selectPage(P page, Map<String, Object> columnMap);

    <P extends IPage<T>> P selectPage(P page);

    /**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     *
     * @param page      分页查询条件
     * @param columnMap 表字段 map 对象
     */
    <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Map<String, Object> columnMap);
}
