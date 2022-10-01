package com.qf.dao;

import com.qf.pojo.CartItem;
import com.qf.pojo.OrderInfo;

import java.util.Collection;

public interface OrderDao {
    boolean cart2db(OrderInfo orderInfo, Collection<CartItem> cartItem);
}
