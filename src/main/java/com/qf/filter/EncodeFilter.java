package com.qf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",
        dispatcherTypes={DispatcherType.FORWARD,DispatcherType.REQUEST},
        initParams ={@WebInitParam(name = "Encode",value = "UTF-8")} )

public class EncodeFilter implements Filter {
    static String encode=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("Encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        servletRequest.setCharacterEncoding(encode);
//        response.setContentType("text/html;charset=utf-8");
        servletResponse.setContentType(encode);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
