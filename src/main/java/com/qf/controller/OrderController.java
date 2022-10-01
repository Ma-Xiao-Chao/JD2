package com.qf.controller;

import com.qf.adminCotroller.BaseController;
import com.qf.dao.impl.OrderInfoDaoImpl;
import com.qf.pojo.OrderDetail;
import com.qf.pojo.OrderInfo;
import com.qf.service.impl.OrderInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;


@WebServlet("/order")
public class OrderController extends BaseController {
    public String orderList(HttpServletRequest req, HttpServletResponse resp){
        //获取session
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        //已经登录
        if (username != null) {
            Integer usid = Integer.parseInt(req.getParameter("usid"));
            //查订单
            Collection<OrderInfo> orderInfos = new OrderInfoServiceImpl().orderInfoByUsid(usid);
            req.setAttribute("orderinfo",orderInfos);
            return "forward:/page/orderList.jsp";
        }
        //未登录
        req.setAttribute("err", "用户未登录,请先登录");
        return "forward:/page/login.jsp";
    }
    public String orderDetail(HttpServletRequest req, HttpServletResponse resp){
        //查订单详情
        int oid = Integer.parseInt(req.getParameter("oid"));
        //业务
        Collection<OrderDetail> orderDetail = new OrderInfoDaoImpl().orderDetialByOid(oid);
        req.setAttribute("orderDetail",orderDetail);
        return "forward:/page/orderDetail.jsp";
    }
}
