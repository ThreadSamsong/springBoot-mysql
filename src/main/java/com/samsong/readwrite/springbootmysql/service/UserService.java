package com.samsong.readwrite.springbootmysql.service;

import com.samsong.readwrite.springbootmysql.config.mysql.DS;
import com.samsong.readwrite.springbootmysql.dao.UserDao;
import com.samsong.readwrite.springbootmysql.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //使用数据源1查询
    @DS("datasource1")
    public List<Map> getAllUser1(){
        return userDao.getAllUser();
    }

    //使用数据源2查询
    @DS("datasource2")
    public List<Map> getAllUser2(){
        return userDao.getAllUser();
    }

}
