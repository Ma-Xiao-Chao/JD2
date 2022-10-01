package com.qf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*",dispatcherTypes={DispatcherType.FORWARD,DispatcherType.REQUEST})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Object username = req.getSession().getAttribute("username");
        if (username!=null && "admin".equals(username)){
            filterChain.doFilter(req,resp);
        }else {
            req.setAttribute("err", "请登录管理员账户");
            req.getRequestDispatcher("/page/login.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
