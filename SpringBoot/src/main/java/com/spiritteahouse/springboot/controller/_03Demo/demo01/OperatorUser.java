package com.spiritteahouse.springboot.controller._03Demo.demo01;

import com.spiritteahouse.springboot.controller._02UnitiveParamResponse.Result;
import com.spiritteahouse.springboot.pojo.Address;
import com.spiritteahouse.springboot.pojo.User;
import com.spiritteahouse.springboot.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperatorUser {
    // http://localhost:8080/operatorUser1
    @RequestMapping("/operatorUser1")
    public Result operatorUser() {
        //解析xml文件，获取数据
        //此行代码用于获取 当前类路径下 的user.xml文件的路径。这里通过类加载器的getResource方法找到资源文件，通常用于从项目类路径中加载静态资源，如配置文件等。
        String path = OperatorUser.class.getClassLoader().getResource("user.xml").getPath();
        List<User> userList = XmlParserUtils.parse(path);

        for (User user : userList) {
            String province = user.getAddress().getProvince() + "省/市";
            String city = user.getAddress().getCity() + "区/县";
            user.setAddress(new Address(province, city));
        }

        //封装返回数据
        return Result.success(userList);
    }
}
