package com.qf.service.impl;

import com.qf.dao.impl.OrderDaoImpl;
import com.qf.dao.impl.OrderInfoDaoImpl;
import com.qf.pojo.OrderDetail;
import com.qf.pojo.OrderInfo;
import com.qf.service.OrderInfoService;

import java.util.Collection;


public class OrderInfoServiceImpl implements OrderInfoService {

    @Override
    public Collection<OrderInfo> orderInfoByUsid(Integer usid) {
        return new OrderInfoDaoImpl().orderInfoByUsid(usid);
    }

    @Override
    public Collection<OrderDetail> orderDetialByOid(Integer oid) {

        return new OrderInfoDaoImpl().orderDetialByOid(oid);
    }

    @Override
    public Collection<OrderInfo> orderAll() {
        return new OrderInfoDaoImpl().orderAll();
    }

    @Override
    public Collection<OrderInfo> orderAll(int page, int limit) {
        return new OrderInfoDaoImpl().orderAll(page,limit);
    }
}
