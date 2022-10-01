package com.qf.adminCotroller;

import com.qf.pojo.Catalog;
import com.qf.service.impl.CatalogServiceImpl;
import com.qf.util.Tran;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class CatalogAdminController extends BaseController {
    //后台
    protected String all(HttpServletRequest req, HttpServletResponse resp){
        return "forward:/admin/mange/index.jsp";
    }
    //all查询
    protected String all1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("UTF-8");//浏览器->服务器
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        //加载所有类别
        String page = req.getParameter("page");//获得前端传来的页数

        //每页行数
        int limit = 5;
        List<Catalog> catalogs = new CatalogServiceImpl().selectAll();
        //总页数
        int totalpage = catalogs.size() % limit == 0 ? catalogs.size() / limit : catalogs.size() / limit + 1;

        int page1 = page == null ? 1 : Integer.parseInt(page);//判断页数是否为空,默认为第一页
        page1 = page1 < 1 ? 1 : page1;//判断页数是否小于1
        page1 = page1 > totalpage ? totalpage : page1;
        //调用service返回结果
        List<Catalog> clist = new CatalogServiceImpl().selectAllByPage(page1, limit);

        //跳转jsp页面,并且携带数据;
        //c发起1/2次请求
        req.setAttribute("clist", clist);//集合对象
        req.setAttribute("page1", page1);//当前前端传来的页数
        req.setAttribute("total", totalpage);//总页数
        /*req.getRequestDispatcher("/admin/data.jsp").forward(req, resp);*/
        return "forward:/admin/data.jsp";
    }

    //all查询使用 页数封装类,暂时没用
/*    protected String all1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载所有类别
        String page = req.getParameter("page");//获得前端传来的页数
        ///////创建实例
        PageBean pageBean = new PageBean();
        //每页行数
        int limit = 5;
        pageBean.setRowsPrePage(5);
        List<Catalog> catalogs = new CatalogServiceImpl().selectAll();
        //总行数
        int rownum = catalogs.size();
        pageBean.setRowNum(rownum);
        //总页数
        int maxpage = pageBean.getMaxPage();


        int page1 = page == null ? 1 : Integer.parseInt(page);//判断页数是否为空,默认为第一页
        pageBean.setPage(page1);
        page1=pageBean.getPage();

        //调用service返回结果
        List<Catalog> clist = new CatalogServiceImpl().selectAllByPage(page1, limit);
        //跳转jsp页面,并且携带数据;
        //c发起1/2次请求
        req.setAttribute("clist", clist);//集合对象
        req.setAttribute("pagebean", pageBean);//当前前端传来的页数
        return "/admin/data.jsp";
    }*/

    //update
    protected String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cid = req.getParameter("id");
        int tmpId = Integer.parseInt(cid);

        String cname = Tran.tran(req.getParameter("cname"));

        String url = req.getParameter("url");

        String level = req.getParameter("level");
        int tmpLevel = Integer.parseInt(level);

        String parent = req.getParameter("parent");
        Object tmpParent = parent;
        if (parent == "") {
            tmpParent = null;
        } else {
            tmpParent = Integer.parseInt(parent);
        }

        String line = req.getParameter("line");
        int tmpLine = Integer.parseInt(line);

        int res = new CatalogServiceImpl().update(cname, url, tmpLevel, tmpParent, tmpLine, tmpId);
        if (res == 1) {
            System.out.println("更改成功");
        }

//        Object obj = new CatalogServiceImpl().selectOne(tmpId);
//        req.setAttribute("obj", obj);
        return "TEMP/admin?action=all1";
    }

    //insert
    protected String insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("UTF-8");//浏览器->服务器
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        String cname = Tran.tran(req.getParameter("cname"));

        String url = req.getParameter("url");

        String level = req.getParameter("level");
        int tmpLevel = Integer.parseInt(level);

        String parent = req.getParameter("parent");
        Object tmpParent = parent;
        if (parent == "") {
            tmpParent = null;
        } else {
            tmpParent = Integer.parseInt(parent);
        }

        String line = req.getParameter("line");
        int tmpLine = Integer.parseInt(line);
        String result = "";
        int res = new CatalogServiceImpl().insert(cname, url, tmpLevel, tmpParent, tmpLine);
        if (res == 1) {
            result = "结果:插入成功";
        } else {
            result = "结果:插入失败";
        }

        req.setAttribute("result", result);
//        req.getRequestDispatcher("/admin/insert.jsp").forward(req, resp);
        return "forward:/admin/insert.jsp";
    }

    //delete
    protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("UTF-8");//浏览器->服务器
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        String id = req.getParameter("id");//获得前端传来的id
        Integer id1 = Integer.parseInt(id);
        int res = new CatalogServiceImpl().delete(id1);
        if (res == 1) {
            System.out.println("删除成功");
        }

        ///////////以下是catalogAdminCotroller代码
        //加载所有类别
        String page = req.getParameter("page");//获得前端传来的页数
        //每页行数
        int limit = 5;
        List<Catalog> catalogs = new CatalogServiceImpl().selectAll(null,null);
        //总页数

        int totalpage = catalogs.size() % limit == 0 ? catalogs.size() / limit : catalogs.size() / limit + 1;

        int page1 = page == null ? 1 : Integer.parseInt(page);//判断页数是否为空,默认为第一页
        page1 = page1 < 1 ? 1 : page1;//判断页数是否小于1
        page1 = page1 > totalpage ? totalpage : page1;
        //调用service返回结果
        List<Catalog> clist = new CatalogServiceImpl().selectAllByPage(page1, limit);

        //跳转jsp页面,并且携带数据;
        //c发起1/2次请求
        req.setAttribute("clist", clist);//集合对象
        req.setAttribute("page1", page1);//当前前端传来的页数
        req.setAttribute("total", totalpage);//总页数
//        req.getRequestDispatcher("/admin/data.jsp").forward(req,resp);
        return "forward:/admin/data.jsp";
    }

    //one
    protected String one(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("UTF-8");//浏览器->服务器
        resp.setContentType("text/html;charset=UTF8");//服务器->浏览器
        //加载所有类别
        String cid = req.getParameter("id");
        int tmpId = Integer.parseInt(cid);
        Object obj = new CatalogServiceImpl().selectOne(tmpId);
        req.setAttribute("obj", obj);
        return "forward:/admin/update.jsp";
    }
}
