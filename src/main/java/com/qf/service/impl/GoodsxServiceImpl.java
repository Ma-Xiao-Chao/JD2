package com.qf.service.impl;

import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.dao.impl.GoodsxDaoImpl;
import com.qf.pojo.Goods;
import com.qf.service.GoodsSerivce;
import com.qf.service.GoodsxService;

import java.util.List;

public class GoodsxServiceImpl implements GoodsxService {
    @Override
    public List<Goods> selectByCondi(String name) {
        List<Goods> goods = new GoodsxDaoImpl().selectByCondi(name);
        return goods;
    }
}
