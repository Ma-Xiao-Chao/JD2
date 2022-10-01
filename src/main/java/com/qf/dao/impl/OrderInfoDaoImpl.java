package com.qf.dao.impl;

import com.qf.dao.OrderInfoDao;
import com.qf.pojo.Goods;
import com.qf.pojo.OrderDetail;
import com.qf.pojo.OrderDetail2;
import com.qf.pojo.OrderInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderInfoDaoImpl extends BaseDao implements OrderInfoDao {
    @Override
    public Collection<OrderInfo> orderInfoByUsid(Integer usid) {
        String sql="select oid,usid,address,phone,zip,status,acceptName,zprice from orderinfo where usid=?";
        return super.selectAll(sql,OrderInfo.class,usid);
    }


    @Override
    public Collection<OrderDetail> orderDetialByOid(Integer oid) {
        String sql="select * from orderdetail where oid=?";
        List<OrderDetail2> list1 = super.selectAll(sql, OrderDetail2.class, oid);
        List<OrderDetail> temp=new ArrayList<>();
        for (OrderDetail2 o2 : list1) {
            int gid = o2.getGid();
            sql = "select g_id gid,c_id cid1,cat_c_id cid2,cat_c_id2 cid3,g_name gname,g_store store,g_pubdate pubdate,g_price price,pic1,pic2,pic3,pic4,info from goods where g_id=?";
            Goods goods = super.selectOne(sql, Goods.class, gid);
            OrderDetail orderDetail = new OrderDetail(o2.getOdid(), o2.getGid(), o2.getNum(), o2.getCurrPrice(), goods.getGname()
                    , goods.getPic1(), o2.getOid());
            temp.add(orderDetail);
        }
        return temp;
    }

    @Override
    public Collection<OrderInfo> orderAll(int page, int limit) {
        String sql="select * from orderinfo ORDER BY oid limit ?,?";
        return super.selectAll(sql,OrderInfo.class,(page - 1) * limit, limit);
    }

    @Override
    public Collection<OrderInfo> orderAll() {
        String sql="select * from orderinfo";
        return super.selectAll(sql,OrderInfo.class);
    }
}
