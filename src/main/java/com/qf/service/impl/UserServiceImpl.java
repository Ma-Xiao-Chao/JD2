package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import com.qf.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public <T>T selectOne() {
        Object obj = new UserDaoImpl().selectOne();
//        User user = null;
//        if (obj instanceof User) {
//            user = (User) obj;
//        }
        return (T) obj;
    }

    @Override
    public <T> T selectOne(String name) {
        return new UserDaoImpl().selectOne(name);
    }

    @Override
    public int addOne(User user) {
        return new UserDaoImpl().addOne(user);
    }

    @Override
    public List<User> allUser(int page, int limit) {
        return new UserDaoImpl().allUser(page,limit);
    }

    @Override
    public List<User> allUser() {
        return new UserDaoImpl().allUser();
    }
}
