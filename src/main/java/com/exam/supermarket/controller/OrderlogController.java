package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.SiteMetadata;
import com.exam.supermarket.constant.RequestScopeConstant;
import com.exam.supermarket.dto.OrderlogStatsDto;
import com.exam.supermarket.metadata.FieldDescriptor;
import com.exam.supermarket.po.OrderlogPo;
import com.exam.supermarket.service.OrderlogService;
import com.exam.supermarket.util.FieldDescriptorUtil;
import com.exam.supermarket.vo.OrderlogStatsVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet({"/orderlog", "/orderlog/*"})
@MultipartConfig
public class OrderlogController extends BaseController<OrderlogPo> {

    public OrderlogController() {
        this.setService(new OrderlogService());
        this.setNoNeedLogin(new String[]{"index"});
    }

    @Override
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("订单列表", "订单列表", "订单列表", "");
        req.setAttribute(RequestScopeConstant.SITE_METADATA, siteMetadata);
        OrderlogStatsDto statsDto = ((OrderlogService) this.getService()).getStats();
        OrderlogStatsVo orderlogStatsVo = new OrderlogStatsVo();
        orderlogStatsVo.setMonthTransaction((new DecimalFormat("0.00")).format(statsDto.getMonthTransaction()));
        orderlogStatsVo.setMonthOrderCount(statsDto.getMonthOrderCount().toString());
        orderlogStatsVo.setTotalTransaction((new DecimalFormat("0.00")).format(statsDto.getTotalTransaction()));
        orderlogStatsVo.setTotalOrderCount(statsDto.getTotalOrderCount().toString());
        req.setAttribute("stats", orderlogStatsVo);
        super.index(req, resp);
    }

    @Override
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("新增订单", "新增订单", "新增订单", "");
        req.setAttribute(RequestScopeConstant.SITE_METADATA, siteMetadata);
        super.add(req, resp);
    }

    @Override
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("修改订单", "修改订单", "修改订单", "");
        req.setAttribute(RequestScopeConstant.SITE_METADATA, siteMetadata);
        super.edit(req, resp);
    }

    protected Map<String, FieldDescriptor> getFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, FieldDescriptor> fields = new LinkedHashMap<>();

        FieldDescriptor idDesc = new FieldDescriptor("id", "ID", false);
        idDesc.setTableHeaderLabel("#");
        idDesc.setReadonly(true);
        idDesc.setDisabled(true);
        fields.put("id", idDesc);

        FieldDescriptor customerDesc = new FieldDescriptor("customerId", "顾客id", true);
        fields.put("customerId", customerDesc);

        FieldDescriptor cashierDesc = new FieldDescriptor("cashierId", "收银员id", true);
        fields.put("cashierId", cashierDesc);

        FieldDescriptor goodDesc = new FieldDescriptor("goodId", "商品", true);
        fields.put("goodId", goodDesc);

        FieldDescriptor payableDesc = new FieldDescriptor("payable", "应付", true);
        fields.put("payable", payableDesc);

        FieldDescriptor paymentDesc = new FieldDescriptor("payment", "实付", true);
        fields.put("payment", paymentDesc);

        FieldDescriptor timeDesc = new FieldDescriptor("time", "交易时间", true);
        fields.put("time", timeDesc);
        return fields;
    }

    @Override
    protected Map<String, FieldDescriptor> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "customerId", "cashierId", "goodId", "payable", "payment", "time"});
    }

    @Override
    protected Map<String, FieldDescriptor> getAddFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"customerId", "cashierId", "goodId", "payable", "payment", "time"});
    }

    @Override
    protected Map<String, FieldDescriptor> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "customerId", "cashierId", "goodId", "payable", "payment", "time"});
    }

}
