package com.qf.dao.impl;


import com.qf.dao.CatalogDao;
import com.qf.pojo.Catalog;
import com.qf.util.SQL;

import java.util.List;

public class CatalogDaoImpl extends BaseDao implements CatalogDao {

    //查多行
    @Override
    public List<Catalog> selectAll(Integer parent, Integer line) {
        StringBuffer stringBuffer = new StringBuffer(SQL.CATALOG);
        if (line != null) {
            //二级
            //sql+="where c_level=2 and c_line=?";
            stringBuffer.append("where c_level=2 and c_line=?");
            return super.selectAll(stringBuffer.toString(), Catalog.class, line);
        } else if (parent != null) {
            //三级
//            sql+="where c_level=3 and c_parent=?";
            stringBuffer.append("where c_level=3 and c_parent=?");
            return super.selectAll(stringBuffer.toString(), Catalog.class, parent);
        } else {
            //一级
//            sql+="where c_level=1";
            stringBuffer.append("where c_level=1");
            return super.selectAll(stringBuffer.toString(), Catalog.class);
        }

    }

    @Override
    public List<Catalog> selectAllByPage(int page, int limit) {
        String sql1 = "select c_id cid,c_name cname,c_url url,c_level level,c_parent parent,c_line line from catalog where c_level=1 or c_level=2 or c_level=3 ORDER BY level limit ?,?";
        return super.selectAll(sql1, Catalog.class, (page - 1) * limit, limit);
    }


    //增删改
    @Override
    public int insert(String cname, String url, int level, Object parent, int line) {
        String sql1 = "INSERT INTO catalog VALUES (null,?,?,?,?,?,null)";

        return super.modify(sql1, cname, url, level, parent, line);
    }

    @Override
    public int delete(int id) {
        String sql1 = "DELETE FROM catalog WHERE c_id=?";
        return super.modify(sql1, id);
    }

    @Override
    public int update(String cname, String url, int level, Object parent, int line, int id) {
        String sql1 = "UPDATE catalog SET c_name=?,c_url=?,c_level=?,c_parent=?,c_line=? where c_id=?";
        return super.modify(sql1, cname, url, level, parent, line, id);

    }

    //cha一条
    @Override
    public <T> T selectOne(int id) {
        String sql1 = "select c_id cid,c_name cname,c_url url,c_level level,c_parent parent,c_line line from catalog WHERE c_id=?";
        return super.selectOne(sql1, Catalog.class, id);
    }

    //查多行
    @Override
    public List<Catalog> selectAll() {
        StringBuffer stringBuffer = new StringBuffer(SQL.CATALOG);
        return super.selectAll(stringBuffer.toString(), Catalog.class);
    }
}
