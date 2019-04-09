package com.samsong.readwrite.springbootmysql.dao;

import com.samsong.readwrite.springbootmysql.entiy.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    //使用xml配置形式查询

    List<Map> getAllUser();
}
