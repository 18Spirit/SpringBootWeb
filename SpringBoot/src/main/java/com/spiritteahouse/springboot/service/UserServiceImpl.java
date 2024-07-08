package com.spiritteahouse.springboot.service;

import com.spiritteahouse.springboot.dao.UserDao;
import com.spiritteahouse.springboot.dao.UserDaoImpl;
import com.spiritteahouse.springboot.pojo.Address;
import com.spiritteahouse.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//业务层
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    public List<User> findAll() {
        //调用持久层，获取集合数据并操作集合数据
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            String province = user.getAddress().getProvince() + "省/市(ioc)";
            String city = user.getAddress().getCity() + "区/县(ioc)";
            user.setAddress(new Address(province, city));
        }
        //把操作完的数据返回给控制层并通过控制层返回给前端
        return userList;
    }
}
