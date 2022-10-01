package com.qf.service;

import com.qf.pojo.OrderDetail;
import com.qf.pojo.OrderInfo;

import java.util.Collection;
import java.util.List;

public interface OrderInfoService {
    Collection<OrderInfo> orderInfoByUsid(Integer usid);
    Collection<OrderDetail> orderDetialByOid(Integer oid);
    Collection<OrderInfo> orderAll();
    Collection<OrderInfo> orderAll(int page, int limit);
}
