package com.exam.supermarket.dao;

import com.exam.core.base.dao.BaseDao;
import com.exam.supermarket.dto.OrderlogStatsDto;
import com.exam.supermarket.po.OrderlogPo;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class OrderlogDao extends BaseDao<OrderlogPo> {

    public OrderlogDao() {
        this.table = "orderlog";
    }

    public OrderlogStatsDto getStats() {
        String sql = """
            select count(*)     as totalOrderCount,
                   sum(payment) as totalTransaction,
                   any_value(oo.monthTransaction) as monthTransaction,
                   any_value(oo.monthOrderCount) as monthOrderCount
            from orderlog o
                     join (select count(*)     as monthOrderCount,
                                  sum(payment) as monthTransaction
                           from orderlog
                           where time >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)) oo;
            """;
        OrderlogStatsDto statsDto = null;
        try {
            statsDto = this.getRunner().query(sql, new BeanHandler<>(OrderlogStatsDto.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statsDto;
    }
}
