package com.qf.controller;


import com.qf.adminCotroller.BaseController;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.impl.UserServiceImpl;
import com.qf.util.Tran;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/user")
public class UserController extends BaseController {
    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//浏览器->服务器
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        User user1 = userService.selectOne(username);
        if (user1 != null) {
            //有该用户
            if (password.equals(user1.getUpass())) {
                //密码正确
                System.out.println("登录成功");
                HttpSession session = req.getSession();
                session.setAttribute("username", user1.getUname());
                session.setAttribute("usid",user1.getUid());
                req.setAttribute("err", "登录成功");
                if ("admin".equals(session.getAttribute("username"))){
                    return "TEMP:/admin";
                }
                return "forward:/page/login.jsp";
            } else {
                //登录失败
                System.out.println("密码错误");
                req.setAttribute("err", "密码错误");
                return "forward:/page/login.jsp";
            }

        } else {
            System.out.println("用户不存在");
            req.setAttribute("err", "用户不存在");
            return "forward:/page/login.jsp";
        }
        //没有用户
//        Object obj = new UserServiceImpl().selectOne();
//        req.setAttribute("obj", obj.toString());
//        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
    public String regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1,接受前端传来参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String birth=req.getParameter("birth");
        String mail=req.getParameter("mail");
        System.out.println(username+password+birth+mail);
//        //2,传到后端
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = null;
        try {
            user = new User(null,username,password,format.parse(birth),mail);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //添加对象
        int res = new UserServiceImpl().addOne(user);
//        3,返回给前端结果
        if (res==0){
            req.setAttribute("res","add fild");
//            req.getRequestDispatcher("forward:/page/regist.jsp").forward(req,resp);
            return "forward:/page/regist.jsp";
        }else {
            //成功....
//            resp.sendRedirect("addUser.jsp");
            req.setAttribute("res","add success");
            return "forward:/page/regist.jsp";
        }
    }
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        try {
            String username = Tran.tran(req.getParameter("username"));
            HttpSession session = req.getSession();
            Object username1 = session.getAttribute("username");
            if (username1!=null && username.equals(username1)){
                //清空session
                session.invalidate();
                System.out.println("退出登录成功");
                System.out.println();
                return "TEMP:/catalog";
            }
            else {
                System.out.println("退出登录失败");
                return "TEMP:/catalog";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
