package com.spiritteahouse.springboot.dao;

import com.spiritteahouse.springboot.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
