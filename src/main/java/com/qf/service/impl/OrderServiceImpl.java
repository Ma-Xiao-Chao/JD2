package com.qf.service.impl;

import com.qf.dao.impl.OrderDaoImpl;
import com.qf.pojo.CartItem;
import com.qf.pojo.OrderInfo;
import com.qf.service.OrderService;

import java.util.Collection;

public class OrderServiceImpl implements OrderService {

    @Override
    public boolean cart2db(OrderInfo orderInfo, Collection<CartItem> cartItem) {
        return new OrderDaoImpl().cart2db(orderInfo,cartItem);
    }
}
