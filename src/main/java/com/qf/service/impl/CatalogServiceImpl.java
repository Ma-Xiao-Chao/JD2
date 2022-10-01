package com.qf.service.impl;


import com.qf.dao.impl.CatalogDaoImpl;
import com.qf.pojo.Catalog;
import com.qf.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {
    @Override
    public List<Catalog> selectAll(Integer parent,Integer line) {
        return new CatalogDaoImpl().selectAll(parent,line);
    }

    @Override
    public List<Catalog> selectAllByPage(int page, int limit) {
        return new CatalogDaoImpl().selectAllByPage(page,limit);
    }

    @Override
    public <T> T selectOne(Integer id) {
        return new CatalogDaoImpl().selectOne(id);
    }

    @Override
    public int update(String cname, String url, int level, Object parent, int line, int id) {
        return new CatalogDaoImpl().update(cname,url,level,parent,line,id);
    }

    @Override
    public int delete(int id) {
        return new CatalogDaoImpl().delete(id);
    }

    @Override
    public int insert(String cname, String url, int level, Object parent, int line) {
        return new CatalogDaoImpl().insert(cname,url,level,parent,line);
    }

    @Override
    public List<Catalog> selectAll() {
        return new CatalogDaoImpl().selectAll();
    }
}
