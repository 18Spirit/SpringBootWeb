package com.spiritteahouse.springboot.service;

import com.spiritteahouse.springboot.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
