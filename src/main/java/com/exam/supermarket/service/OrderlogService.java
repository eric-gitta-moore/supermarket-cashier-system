package com.exam.supermarket.service;

import com.exam.core.base.service.BaseService;
import com.exam.core.common.metadata.IPage;
import com.exam.core.common.plugin.pagination.Page;
import com.exam.core.common.util.GenericsUtils;
import com.exam.core.common.util.SqlUtil;
import com.exam.core.common.util.StrUtil;
import com.exam.supermarket.bo.OrderLogBo;
import com.exam.supermarket.dao.OrderlogDao;
import com.exam.supermarket.dto.OrderLogDto;
import com.exam.supermarket.dto.OrderlogStatsDto;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.po.OrderlogPo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderlogService extends BaseService<OrderlogPo> {

    private GoodService goodService = new GoodService();

    public OrderlogService() {
        this.dao = new OrderlogDao();
    }

    public OrderlogStatsDto getStats() {
        return ((OrderlogDao) this.dao).getStats();
    }

    public IPage<OrderLogBo> pageBo(IPage<OrderLogBo> page) {
        Page<OrderLogDto> orderLogDtoPage = new Page<>();
        try {
            BeanUtils.copyProperties(orderLogDtoPage, page);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        ((OrderlogDao) this.getDao()).selectTablePage(orderLogDtoPage);
        page.setTotal(orderLogDtoPage.getTotal());
        Set<Integer> goodIds = new HashSet<>();
        orderLogDtoPage.getRecords().forEach(e -> goodIds.addAll(
            Arrays.asList(e.getGoodId().split(","))
                .stream().map(Integer::valueOf)
                .toList()
        ));

        Map<String, GoodPo> goodPoMap = goodService.keyedListByIds(goodIds);
        List<OrderLogBo> orderLogBoList = orderLogDtoPage.getRecords().stream().map(e -> {
            Set<String> ids = new HashSet<>(Arrays.asList(e.getGoodId().split(",")));
            Map<String, Integer> statMap = StrUtil.statOccurrences(ids);

            List<String> goodNameList = ids.stream().map(id -> {
                String name = goodPoMap.get(id).getName();
                return String.format("%sx%s", name, statMap.get(id));
            }).toList();
            OrderLogBo orderLogBo = new OrderLogBo();
            try {
                BeanUtils.copyProperties(orderLogBo, e);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
            orderLogBo.setGoodName(goodNameList);
            return orderLogBo;
        }).collect(Collectors.toList());
        page.setRecords(orderLogBoList);
        return page;
    }
}
