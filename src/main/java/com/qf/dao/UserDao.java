package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

public interface UserDao {
    <T> T selectOne();
    <T> T selectOne(String name);
    int addOne(User user);
    List<User> allUser(int page, int limit);
    List<User> allUser();
}
