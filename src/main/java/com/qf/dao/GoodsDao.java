package com.qf.dao;

import com.qf.pojo.Catalog;
import com.qf.pojo.Goods;
import com.qf.vo.PageBean;

import java.util.List;

public interface GoodsDao {
    //查询所有商品+分页+按类别
    List<Goods> selectAllByCid(Integer cid,PageBean pageBean,Integer level);
    //查一个
    Goods selectOne(Integer gid);
    //查goods表
    List<Goods> selectAll();
    //分页
    List<Goods> selectAllByPage(int page, int limit);
}
