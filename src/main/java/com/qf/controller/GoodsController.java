package com.qf.controller;

import com.qf.adminCotroller.BaseController;
import com.qf.pojo.Goods;
import com.qf.service.GoodsSerivce;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods")
public class GoodsController extends BaseController {
    private GoodsSerivce goodsService=new GoodsServiceImpl();
    public String all(HttpServletRequest req, HttpServletResponse resp){
        String cid1 = req.getParameter("cid");
        Integer cid = Integer.parseInt(cid1);
        String level1 = req.getParameter("level");
        Integer level = Integer.parseInt(level1);

//        System.out.println(level);
//        System.out.println(cid);
        List<Goods> goods = goodsService.selectAllByCid(cid, null,level);
        req.setAttribute("goods",goods);
        return "forward:/page/goodsType.jsp";
    }

    public String xiangqing(HttpServletRequest req, HttpServletResponse resp){
        String gid1 = req.getParameter("gid");
        Integer gid = Integer.parseInt(gid1);
//        System.out.println(gid);
        Goods goods = goodsService.selectOne(gid);
        req.setAttribute("goods",goods);
        return "forward:/page/goods.jsp";
    }
}
