package com.exam.supermarket.dao;

import com.exam.core.base.dao.BaseDao;
import com.exam.core.common.metadata.IPage;
import com.exam.supermarket.dto.OrderLogDto;
import com.exam.supermarket.dto.OrderlogStatsDto;
import com.exam.supermarket.po.OrderlogPo;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
        OrderlogStatsDto statsDto;
        try {
            statsDto = this.getRunner().query(sql, new BeanHandler<>(OrderlogStatsDto.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statsDto;
    }

    public IPage<OrderLogDto> selectTablePage(IPage<OrderLogDto> page) {
        page.setTotal(this.selectCount(new HashMap<>()));

        String sql = """
            select orderlog.id,
                   customerId,
                   u1.name as customerName,
                   cashierId,
                   u2.name as cashierName,
                   goodId,
                   payable,
                   payment,
                   goodsTag,
                   time
            from orderlog
                     left join user u1 on customerId = u1.id
                     left join user u2 on cashierId = u2.id
            limit ?,?
                        """;
        List<OrderLogDto> list = null;
        try {
            list = this.getRunner().query(sql, new BeanListHandler<>(OrderLogDto.class), page.offset(), page.getSize());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        page.setRecords(list);
        return page;
    }
}
