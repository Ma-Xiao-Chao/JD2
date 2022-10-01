package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.Catalog;
import com.qf.pojo.User;
import com.qf.util.Utils;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public <T>T selectOne() {
        return selectOne("select * from sys_user WHERE uid=?", User.class, 1);
    }

    @Override
    public <T> T selectOne(String name) {
        return selectOne("select * from sys_user WHERE uname=?", User.class, name);
    }

    @Override
    public int addOne(User user) {
        String sql="insert into sys_user  values (null,?,?,?,?)";
        return modify(sql,user.getUname(),user.getUpass(), Utils.dateToStr(user.getUbirth()),user.getUmail());
    }

    @Override
    public List<User> allUser(int page, int limit) {
        String sql="select * from sys_user ORDER BY uid limit ?,?";
        return super.selectAll(sql, User.class, (page - 1) * limit, limit);
    }

    @Override
    public List<User> allUser() {
        String sql="select * from sys_user";
        return super.selectAll(sql, User.class);
    }
}
