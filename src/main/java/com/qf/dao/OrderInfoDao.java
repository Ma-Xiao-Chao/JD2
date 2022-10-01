package com.qf.dao;

import com.qf.pojo.OrderDetail;
import com.qf.pojo.OrderInfo;

import java.util.Collection;

public interface OrderInfoDao {
    Collection<OrderInfo> orderInfoByUsid(Integer usid);
    Collection<OrderDetail> orderDetialByOid(Integer oid);
    Collection<OrderInfo> orderAll();
    Collection<OrderInfo> orderAll(int page, int limit);
}
