package com.qf.dao.impl;

import com.qf.dao.GoodsDao;
import com.qf.pojo.Catalog;
import com.qf.pojo.Goods;
import com.qf.util.SQL;
import com.qf.vo.PageBean;

import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public List<Goods> selectAllByCid(Integer cid, PageBean pageBean,Integer level) {
        //类别cid       分页
        if (pageBean ==null){
            String sql="";
            if (level==1){
                sql= SQL.GOODS+" where c_id=?";
            }else if (level==2){
                sql= SQL.GOODS+" where cat_c_id=?";
            }else {
                sql= SQL.GOODS+" where cat_c_id2=?";
            }
            return selectAll(sql,Goods.class,cid);
        }
        String sql=SQL.GOODS+"where c_id=?  limit ?,?";
        return selectAll(sql,Goods.class,cid,(pageBean.getPage()-1)*pageBean.getRowNum(),pageBean.getRowNum());
    }

    @Override
    public Goods selectOne(Integer gid) {
        String sql= SQL.GOODS+" where g_id=?";
        return selectOne(sql,Goods.class,gid);
    }

    @Override
    public List<Goods> selectAll() {
        String sql= SQL.GOODS;
        return selectAll(sql,Goods.class);
    }

    @Override
    public List<Goods> selectAllByPage(int page, int limit) {
        String sql= SQL.GOODS;
        String sql1 =sql+ " ORDER BY g_id limit ?,?";
        return super.selectAll(sql1, Goods.class, (page - 1) * limit, limit);
    }
}
