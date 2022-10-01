package com.qf.adminCotroller;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //子类方法名
        String action = req.getParameter("action");
        //空 查
        if (action == null)
            action = "all";
//        System.out.println("action=" + action);
//        System.out.println(this);
//            子类方法名
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //子类方法执行  子类方法返回值--跳转路径
            Object path = method.invoke(this, req, resp);
            if (path instanceof String) {
                String  url = (String) path;
                if (url.startsWith("TEMP")) {
                    String substring = url.substring(5);
                    resp.sendRedirect(substring);
                    return;
                }else if (url.startsWith("forward")){
                    //跳转页面
                    req.getRequestDispatcher(url.substring(8)).forward(req, resp);
                    return;
                }else {
                    PrintWriter pw = resp.getWriter();
                    pw.write(url);
                    pw.flush();
                    pw.close();
                }

            }

    }
}
