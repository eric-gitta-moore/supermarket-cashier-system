package com.exam.supermarket.controller;

import com.exam.core.base.controller.BaseController;
import com.exam.core.common.metadata.SiteMetadata;
import com.exam.core.common.util.StrUtil;
import com.exam.supermarket.constant.RequestScopeConstant;
import com.exam.supermarket.constant.SessionConstant;
import com.exam.supermarket.metadata.FieldDescriptor;
import com.exam.supermarket.po.GoodPo;
import com.exam.supermarket.po.OrderlogPo;
import com.exam.supermarket.po.UserPo;
import com.exam.supermarket.service.GoodService;
import com.exam.supermarket.service.OrderlogService;
import com.exam.supermarket.service.UserService;
import com.exam.supermarket.util.FieldDescriptorUtil;
import com.exam.supermarket.vo.CashierGoodVo;
import com.exam.supermarket.vo.ToastVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

@WebServlet({"/cashier", "/cashier/*"})
@MultipartConfig
public class CashierController extends BaseController<GoodPo> {

    private UserService userService = new UserService();
    private OrderlogService orderlogService = new OrderlogService();

    public CashierController() {
        this.setService(new GoodService());
        this.setNoNeedLogin(new String[]{});
    }

    @Override
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SiteMetadata siteMetadata = new SiteMetadata("收银台", "收银台", "收银台");
        req.setAttribute("siteMetadata", siteMetadata);
        req.setAttribute("goodIds", String.join(",", Collections.emptyList()));
        this.autoForward(req, resp);
    }

    /**
     * 添加商品到收银台
     *
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String newGoodId = req.getParameter("good");
        List<String> goodIds = new ArrayList<>(Arrays.asList(req.getParameter("goodIds").split(",")));
        goodIds.add(newGoodId);
        goodIds = goodIds.stream().filter(e -> !"".equals(e)).toList();

        // 构建CashierGoodVo
        List<CashierGoodVo> cashierGoodVoList = this.convertGoodIds(goodIds);

        if (this.getService().getById(newGoodId) == null) {
            req.setAttribute(RequestScopeConstant.TOAST,
                new ToastVo("提示", String.format("未找到货号为%s的商品", newGoodId)));
        }
        req.setAttribute(RequestScopeConstant.RECORDS, cashierGoodVoList);
        req.setAttribute("goodIds", String.join(",", goodIds));
        req.setAttribute("payable", (new DecimalFormat("0.00")).format(calcPayable(cashierGoodVoList)));
        req.setAttribute(RequestScopeConstant.FIELDS, getIndexFields(req, resp));
        this.autoForward(req, resp, "index");
    }

    protected List<CashierGoodVo> convertGoodIds(List<String> goodIds) {
        goodIds = goodIds.stream().filter(e -> !"".equals(e)).toList();

        List<GoodPo> goodPos = this.getService().listByIds(goodIds);
        Map<String, Integer> statOccurrences = StrUtil.statOccurrences(goodIds);

        // 构建CashierGoodVo
        return goodPos.stream().map(e -> {
            CashierGoodVo cashierGoodVo = new CashierGoodVo();
            try {
                BeanUtils.copyProperties(cashierGoodVo, e);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
            cashierGoodVo.setNum(statOccurrences.get(String.valueOf(e.getId())));
            return cashierGoodVo;
        }).toList();
    }

    protected double calcPayable(List<CashierGoodVo> cashierGoodVoList) {
        double total = 0;
        for (CashierGoodVo cashierGoodVo : cashierGoodVoList) {
            total += cashierGoodVo.getPrice() * cashierGoodVo.getNum();
        }
        return total;
    }


    /**
     * 提交订单
     *
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    protected synchronized void submit(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {
        String vip = req.getParameter("vip");
        List<String> goodIds = new ArrayList<>(Arrays.asList(req.getParameter("goodIds").split(",")));
        goodIds = goodIds.stream().filter(e -> !"".equals(e)).toList();

        // 构建CashierGoodVo
        List<CashierGoodVo> cashierGoodVoList = this.convertGoodIds(goodIds);
        String formatPayable = (new DecimalFormat("0.00")).format(calcPayable(cashierGoodVoList));

        // 判断爆库存
        boolean isOutOfStock = cashierGoodVoList.stream().anyMatch(e -> e.getStock() - e.getNum() <= 0);
        if (isOutOfStock) {
            req.setAttribute(RequestScopeConstant.TOAST,
                new ToastVo("提示", "商品差多了，要不要换一件？"));

            req.setAttribute(RequestScopeConstant.RECORDS, cashierGoodVoList);
            req.setAttribute("goodIds", String.join(",", goodIds));
            req.setAttribute("payable", formatPayable);
            req.setAttribute(RequestScopeConstant.FIELDS, getIndexFields(req, resp));
            this.autoForward(req, resp, "index");
            return;
        }

        // 应付
        double payable = Double.parseDouble(formatPayable);
        // 实付
        double payment = payable;
        UserPo userPo = (UserPo) req.getSession().getAttribute(SessionConstant.USER_INSTANCE);

        UserPo customer = null;
        if (vip != null && !"".equals(vip)) {
            customer = new UserPo();
            customer.setVip(vip);
            customer = this.userService.getOne(customer);
        }

        OrderlogPo orderlogPo = new OrderlogPo();
        if (customer != null) {
            orderlogPo.setCustomerId(customer.getId());
            if (customer.getVip() != null && !"".equals(customer.getVip())) {
                payment *= 0.9;
            }
        }
        orderlogPo.setCashierId(userPo.getId());
        orderlogPo.setGoodId(String.join(",", goodIds));
        orderlogPo.setPayable(payable);
        orderlogPo.setPayment(payment);
        orderlogPo.setTime(new Timestamp(new Date().getTime()));

        this.orderlogService.save(orderlogPo);
        this.forwardHome(req, resp);
    }

    protected Map<String, FieldDescriptor> getFields(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, FieldDescriptor> fields = new LinkedHashMap<>();

        FieldDescriptor idDesc = new FieldDescriptor("id", "ID", false);
        idDesc.setTableHeaderLabel("#");
        idDesc.setReadonly(true);
        idDesc.setDisabled(true);
        fields.put("id", idDesc);

        fields.put("name", new FieldDescriptor("name", "商品名", true));

        fields.put("price", new FieldDescriptor("price", "价格", true));

        fields.put("num", new FieldDescriptor("num", "数量", true));

        fields.put("stock", new FieldDescriptor("stock", "库存", true));
        return fields;
    }

    @Override
    protected Map<String, FieldDescriptor> getIndexFields(HttpServletRequest req, HttpServletResponse resp) {
        return FieldDescriptorUtil.filterDescriptor(this.getFields(req, resp),
            new String[]{"id", "name", "num", "price", "stock"});
    }

}
