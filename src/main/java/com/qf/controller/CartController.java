package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.adminCotroller.BaseController;
import com.qf.pojo.CartItem;
import com.qf.pojo.Goods;
import com.qf.pojo.OrderInfo;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.OrderInfoServiceImpl;
import com.qf.service.impl.OrderServiceImpl;
import com.qf.util.Tran;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cart")
public class CartController extends BaseController {
    //结算页面跳到  订单写到数据库  清空购物车
    public String cart2db(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");//浏览器->服务器
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        String acceptName = null;
        String address = null;
        try {
            acceptName = Tran.tran(req.getParameter("acceptName"));
            address = Tran.tran(req.getParameter("address"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String phone = req.getParameter("phone");
        String zip = req.getParameter("zip");
        String sum = req.getParameter("sumMoney");
        Integer zprice = Integer.parseInt(sum);
        HttpSession session = req.getSession();
        Integer usid = (Integer) session.getAttribute("usid");
        session.setAttribute("usid",usid);
//        System.out.println("usid="+usid);
        OrderInfo orderInfo = new OrderInfo(0, usid, address, phone, zip, 3, acceptName, zprice);
        //将订单信息写到数据库
//        int i = new CartServiceImpl().cart2db(orderInfo);
//        System.out.println("结果="+i);
        //订单详情写到数据库
        Map<Integer, CartItem> cart1 = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        Collection<CartItem> items = cart1.values();

        boolean b = new OrderServiceImpl().cart2db(orderInfo, items);
        if (b) {
            req.getSession().removeAttribute("cart");
            return "forward:/order?action=orderList&usid="+usid;
        } else{
            return "404";
        }
    }

    //购物车跳到结算页面
    public String jiesuan(HttpServletRequest req, HttpServletResponse resp) {
        String sum1 = req.getParameter("sum");
        Integer sum = Integer.parseInt(sum1);
        req.setAttribute("sum", sum);
        HttpSession session = req.getSession();
        Object cart = session.getAttribute("cart");
        System.out.println(cart);
        if (cart!=null){
            return "forward:/page/sendInfo.jsp";
        }
        return "forward:/page/cart.jsp";
    }

    public String subOne(HttpServletRequest req, HttpServletResponse resp) {
        Integer gid = req.getParameter("gid") == null ? 0 : Integer.parseInt(req.getParameter("gid"));
        System.out.println(gid);
        Map<Integer, CartItem> cart1 = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        Integer num = cart1.get(gid).getNum();
        if (num > 1) {
            cart1.get(gid).setNum(num - 1);
//            return "TEMP:/page/cart.jsp";
            return JSON.toJSONString(cart1.get(gid).getNum());
        } else {
            del(req, resp);
            return "forward:/page/cart.jsp";
        }

    }

    public String addOne(HttpServletRequest req, HttpServletResponse resp) {
        Integer gid = req.getParameter("gid") == null ? 0 : Integer.parseInt(req.getParameter("gid"));
        System.out.println(gid);
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart1 = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");

        cart1.get(gid).setNum(cart1.get(gid).getNum() + 1);
        return JSON.toJSONString(cart1.get(gid).getNum());
    }

    public String del(HttpServletRequest req, HttpServletResponse resp) {
        Integer gid = req.getParameter("gid") == null ? 0 : Integer.parseInt(req.getParameter("gid"));
//        System.out.println(gid);
        //获取session
        HttpSession session = req.getSession();
        //获取session
        Map<Integer, CartItem> cart1 = (Map<Integer, CartItem>) session.getAttribute("cart");
        cart1.remove(gid);
        if (cart1.size() == 0) {
            return "forward:/goods?action=xiangqing&gid=" + gid;
        }
        return "TEMP:/page/cart.jsp";
    }

    public String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer gid = req.getParameter("gid") == null ? 0 : Integer.parseInt(req.getParameter("gid"));
        //获取session
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        //已经登录
        if (username != null) {
            //判断是否有购物车
            Object cart = session.getAttribute("cart");
            if (cart == null) {//没有购物车
                //添加购物车
                //新建map==购物车
                HashMap<Integer, CartItem> cartMap = new HashMap<>();
                //根据gid新建cartltem
                Goods goods = new GoodsServiceImpl().selectOne(gid);
                CartItem cartItem = new CartItem(goods, 1);
                //map添加商品
                cartMap.put(gid, cartItem);
                //map添加添加到session
                session.setAttribute("cart", cartMap);
                //购物车数量===========
                return "TEMP:/page/cart.jsp";
            } else {//有购物车
                //获取session
                Map<Integer, CartItem> cart1 = (Map<Integer, CartItem>) session.getAttribute("cart");
                //购物车数量===========

                //判断购物车是否已经存在该商品
                if (cart1.containsKey(gid)) {//有
                    cart1.get(gid).setNum(cart1.get(gid).getNum() + 1);//数量加一
                    return "TEMP:/page/cart.jsp";
                } else {//无
                    //根据gid新建cartltem
                    Goods goods = new GoodsServiceImpl().selectOne(gid);
                    CartItem cartItem = new CartItem(goods, 1);
                    //map添加商品
                    cart1.put(gid, cartItem);
                    //login
                    return "forward:/page/cart.jsp";
                }
            }
        }
        //未登录
        req.setAttribute("err", "用户未登录,请先登录");
        return "forward:/page/login.jsp";
    }

    public String indexInCart(HttpServletRequest req, HttpServletResponse resp){
        //获取session
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        //已经登录
        if (username != null) {
            //进入购物车
            return "forward:/page/cart.jsp";
        }
        //未登录
        req.setAttribute("err", "用户未登录,请先登录");
        return "forward:/page/login.jsp";
    }
}
