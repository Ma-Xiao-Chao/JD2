package com.qf.controller;


import com.alibaba.fastjson.JSON;
import com.qf.adminCotroller.BaseController;
import com.qf.pojo.Catalog;
import com.qf.service.CatalogService;
import com.qf.service.impl.CatalogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet("/catalog")
public class CatalogController extends BaseController {
    private CatalogService catalogService = new CatalogServiceImpl();

    public String selectById(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("utf-8");
        //line
        String line = req.getParameter("line");
//        System.out.println(line);
        //二级
        List<Catalog> clist = catalogService.selectAll(null, Integer.parseInt(line));
        ArrayList<Object> finallist = new ArrayList<>();
//        三级
        for (Catalog catalog : clist) {
            List<Catalog> sanjigeti = catalogService.selectAll(catalog.getCid(), null);
            finallist.add(catalog);
            finallist.add(sanjigeti);
        }
//        req.setAttribute("map",map);

        String mapStr = JSON.toJSONString(finallist);
        return mapStr;

    }

    public String all(HttpServletRequest req, HttpServletResponse resp) {
        //加载所有类别
        //调用service返回结果
        List<Catalog> clist = catalogService.selectAll(null, null);
        //跳转jsp页面,并且携带数据;
        //c发起1/2次请求
        req.setAttribute("clist", clist);
        return "forward:/page/index.jsp";
    }

}
