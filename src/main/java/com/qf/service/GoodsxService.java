package com.qf.service;

import com.qf.pojo.Goods;

import java.util.List;

public interface GoodsxService {
    List<Goods> selectByCondi(String name);
}
