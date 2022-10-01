package com.qf.controller;

import com.qf.pojo.Goods;
import com.qf.service.GoodsxService;
import com.qf.service.impl.GoodsxServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goodsx")
public class GoodsxController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("UTF-8");//浏览器->服务器
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        String condi = req.getParameter("condition");
        System.out.println(condi);
        GoodsxService goodsxService = new GoodsxServiceImpl();
        List<Goods> goods = goodsxService.selectByCondi(condi);
//        System.out.println(goods);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/page/goodsType.jsp").forward(req,resp);
    }
}
