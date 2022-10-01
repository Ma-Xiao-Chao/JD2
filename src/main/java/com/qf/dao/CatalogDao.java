package com.qf.dao;

import com.qf.pojo.Catalog;

import java.util.List;

public interface CatalogDao {
    List<Catalog> selectAll(Integer parent, Integer line);
    List<Catalog> selectAllByPage(int page, int limit);
    <T> T selectOne(int id);
    int insert(String cname,String url,int level,Object parent,int line);
    int delete(int id);
    int update(String cname,String url,int level,Object parent,int line,int id);
    List<Catalog> selectAll();
}
