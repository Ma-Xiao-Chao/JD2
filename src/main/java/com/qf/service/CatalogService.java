package com.qf.service;

import com.qf.pojo.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> selectAll(Integer parent, Integer line);
    List<Catalog> selectAllByPage(int page, int limit);
    <T> T selectOne(Integer id);
    int update(String cname,String url,int level,Object parent,int line,int id);
    int delete(int id);
    int insert(String cname,String url,int level,Object parent,int line);
    List<Catalog> selectAll();

}
