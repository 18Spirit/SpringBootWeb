package com.spiritteahouse.springboot.dao;


import com.spiritteahouse.springboot.pojo.User;
import com.spiritteahouse.springboot.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

//持久层
@Component
public class UserDaoImpl implements UserDao {

    public List<User> findAll() {
        //获取xml文件数据，并把数据封装到集合中
        String path = UserDaoImpl.class.getClassLoader().getResource("user.xml").getPath();
        List<User> userList = XmlParserUtils.parse(path);
        return userList;
    }
}
