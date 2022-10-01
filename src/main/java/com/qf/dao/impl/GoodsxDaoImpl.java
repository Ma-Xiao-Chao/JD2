package com.qf.dao.impl;

import com.qf.pojo.Goods;
import com.qf.service.GoodsxService;
import com.qf.util.SQL;

import java.util.List;

public class GoodsxDaoImpl extends BaseDao implements GoodsxService {
    @Override
    public List<Goods> selectByCondi(String name) {
        BaseDao baseDao = new BaseDao();
        String sql = "select g_id gid,g.c_id cid1,cat_c_id cid2,cat_c_id2 cid3,g_name gname,g_store store,g_pubdate pubdate,g_price price,pic1,pic2,pic3,pic4,info from goods g,catalog c where g.c_id=c.c_id and c.c_name like CONCAT('%',?,'%')";
        List<Goods> list = baseDao.selectAll(sql, Goods.class, name);
        return list;
    }
}
