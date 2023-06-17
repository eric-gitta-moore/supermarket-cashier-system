package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseServlet;
import com.exam.supermarket.dao.GoodDao;
import com.exam.supermarket.po.GoodPo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.*;

@WebServlet("/test")
public class TestServlet extends BaseServlet {

    private GoodDao goodDao = new GoodDao();

    public void selectByIdTest() {
        try {
            GoodPo goodPo = goodDao.selectById(1);
            System.out.println(goodPo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectListTest() {
        try {
            GoodPo goodPo = new GoodPo();
            goodPo.setId(1);
            List<GoodPo> goodPos = goodDao.selectList(goodPo);
            System.out.println(goodPos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTest() {
        try {
            GoodPo goodPo = goodDao.selectById(1);
            goodPo.setPrice(6666.0);
            int updated = goodDao.updateById(goodPo);
            System.out.println(updated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectCountTest() {
        try {
            Long goodPos = goodDao.selectCount(new HashMap<>());
            System.out.println(goodPos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectBatchIdsTest() {
        try {
            List<String> ids = Arrays.asList(new String[]{"3"});
            List<GoodPo> goodPos = goodDao.selectBatchIds(ids);
            System.out.println(goodPos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByIdTest() {
        try {
            int deleted = goodDao.deleteById(4);
            System.out.println(deleted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertTest() {
        try {
            GoodPo goodPo = new GoodPo();
            goodPo.setName("1212");
            goodPo.setPrice(111.1);
            goodPo.setStock(11);
            GoodPo inserted = goodDao.insert(goodPo);
            System.out.println(inserted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        insertTest();
    }
}
