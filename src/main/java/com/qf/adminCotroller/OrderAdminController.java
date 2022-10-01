package com.qf.adminCotroller;

import com.qf.pojo.Goods;
import com.qf.pojo.OrderInfo;
import com.qf.service.OrderInfoService;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.OrderInfoServiceImpl;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
@WebServlet("/orderMange")
public class OrderAdminController extends BaseController{
    //all查询
    protected String all(HttpServletRequest req, HttpServletResponse resp){
        //编码
        try {
            req.setCharacterEncoding("UTF-8");//浏览器->服务器
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        //加载所有类别
        String page = req.getParameter("page");//获得前端传来的页数

        //每页行数
        int limit = 2;
        Collection<OrderInfo> catalogs = new OrderInfoServiceImpl().orderAll();
        //总页数
        int totalpage = catalogs.size() % limit == 0 ? catalogs.size() / limit : catalogs.size() / limit + 1;

        int page1 = page == null ? 1 : Integer.parseInt(page);//判断页数是否为空,默认为第一页
        page1 = page1 < 1 ? 1 : page1;//判断页数是否小于1
        page1 = page1 > totalpage ? totalpage : page1;
        //调用service返回结果
        Collection<OrderInfo> olist = new OrderInfoServiceImpl().orderAll(page1, limit);
        //跳转jsp页面,并且携带数据;
        //c发起1/2次请求
        req.setAttribute("olist", olist);//集合对象
        req.setAttribute("page1", page1);//当前前端传来的页数
        req.setAttribute("total", totalpage);//总页数
        /*req.getRequestDispatcher("/admin/data.jsp").forward(req, resp);*/
        return "forward:/admin/mange/orderMange.jsp";
    }
}
