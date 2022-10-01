package com.qf.dao;

import com.qf.pojo.Goods;

import java.util.List;

public interface GoodsxDao{
    List<Goods> selectByCondi(String name);
}
