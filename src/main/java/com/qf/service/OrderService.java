package com.qf.service;

import com.qf.pojo.CartItem;
import com.qf.pojo.OrderInfo;

import java.util.Collection;

public interface OrderService {
    //订单信息写入到db
    boolean cart2db(OrderInfo orderInfo, Collection<CartItem> cartItem);
}
