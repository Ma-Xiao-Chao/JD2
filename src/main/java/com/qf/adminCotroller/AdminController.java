package com.qf.adminCotroller;

import com.qf.util.Tran;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@WebServlet("/adminMange")
public class AdminController extends BaseController{
    //登录
    protected String all(HttpServletRequest req, HttpServletResponse resp){
        try {
            String username = Tran.tran(req.getParameter("username"));
            String password = Tran.tran(req.getParameter("password"));
            System.out.println("来了,来到后台登陆了");
            if ("admin".equals(username)){//是admin
                //获得密码
                //////////////////////这里补业务
                if ("admin".equals(password)){
                    return "forward:/admin/mange/index.jsp";
                }else {
                    req.setAttribute("err","Waring!密码错误");
                    return "forward:/admin";
                }
            }else {
                req.setAttribute("err","Waring!抱歉,您没有权限");
                return "forward:/admin";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "forward:/404";
    }
}
