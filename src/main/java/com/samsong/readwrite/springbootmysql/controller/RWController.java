package com.samsong.readwrite.springbootmysql.controller;

import com.samsong.readwrite.springbootmysql.entiy.User;
import com.samsong.readwrite.springbootmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RWController {

    @Autowired
    UserService userService;

    //数据源1查询数据
    @GetMapping(value = "/test1")
    @ResponseBody
    public String testOne(){
        List<Map> list = userService.getAllUser1();
        return "success";
    }

    //数据源2查询数据
    @GetMapping(value = "/test2")
    @ResponseBody
    public String testTwo(){
        List<Map> list = userService.getAllUser2();
        return "success";
    }

}
