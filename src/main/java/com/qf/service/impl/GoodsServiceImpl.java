package com.qf.service.impl;

import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.pojo.Catalog;
import com.qf.pojo.Goods;
import com.qf.service.GoodsSerivce;
import com.qf.vo.PageBean;

import java.util.List;

public class GoodsServiceImpl implements GoodsSerivce {
    @Override
    public List<Goods> selectAllByCid(Integer cid, PageBean pageBean,Integer level) {
        return new GoodsDaoImpl().selectAllByCid(cid,pageBean,level);
    }

    @Override
    public Goods selectOne(Integer gid) {
        return new GoodsDaoImpl().selectOne(gid);
    }

    @Override
    public List<Goods> selectAll() {
        return new GoodsDaoImpl().selectAll();
    }

    @Override
    public List<Goods> selectAllByPage(int page, int limit) {
        return new GoodsDaoImpl().selectAllByPage(page,limit);
    }


}
