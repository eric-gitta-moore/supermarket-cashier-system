package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.SiteMetadata;
import com.exam.supermarket.metadata.FieldDescriptor;
import com.exam.supermarket.po.OrderlogPo;
import com.exam.supermarket.service.OrderlogService;
import com.exam.supermarket.util.FieldDescriptorUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet({"/orderlog", "/orderlog/*"})
public class OrderlogController extends BaseController<OrderlogPo> {

    public OrderlogController() {
        this.setService(new OrderlogService());
        this.setNoNeedLogin(new String[]{"index"});
    }

    @Override
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("订单列表", "订单列表", "订单列表", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.index(req, resp);
    }

    @Override
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("新增订单", "新增订单", "新增订单", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.add(req, resp);
    }

    @Override
    protected void change(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("修改订单", "修改订单", "修改订单", "");
        req.setAttribute("siteMetadata", siteMetadata);
        super.change(req, resp);
    }

    protected Map<String, FieldDescriptor> getFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, FieldDescriptor> fields = new LinkedHashMap<>();

        FieldDescriptor idDesc = new FieldDescriptor("id", "ID", false);
        idDesc.setTableHeaderLabel("#");
        idDesc.setReadonly(true);
        idDesc.setDisabled(true);
        fields.put("id", idDesc);

        FieldDescriptor customerDesc = new FieldDescriptor("customer_id", "顾客id", true);
        fields.put("customer_id", customerDesc);

        FieldDescriptor cashierDesc = new FieldDescriptor("cashier_id", "收银员id", true);
        fields.put("cashier_id", cashierDesc);

        FieldDescriptor goodDesc = new FieldDescriptor("good_id", "商品id", true);
        fields.put("good_id", goodDesc);

        FieldDescriptor numDesc = new FieldDescriptor("num", "购买数量", true);
        fields.put("num", numDesc);

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
            new String[]{"id", "customer_id", "cashier_id", "good_id", "num", "payable", "payment", "time"});
    }

    @Override
    protected Map<String, FieldDescriptor> getAddFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"customer_id", "cashier_id", "good_id", "num", "payable", "payment", "time"});
    }

    @Override
    protected Map<String, FieldDescriptor> getUpdateFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "customer_id", "cashier_id", "good_id", "num", "payable", "payment", "time"});
    }

}
