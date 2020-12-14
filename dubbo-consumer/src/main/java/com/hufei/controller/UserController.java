package com.hufei.controller;

import com.hufei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 控制层
 * @author: hufei
 * @date: 2020/12/12 12:59
 * @version: 1.0.0
 */
@RestController
public class UserController {

    @Autowired(required = false)
    private IUserService userService;

    //这种配置produces的方式优于<mvc:annotation-driven />注解驱动方式配置消息转换器生效
//    @GetMapping(value = "/findTest/{userId}", produces="text/json;charset=UTF-8")
    @GetMapping(value = "/findTest/{userId}/{name}")
    public String method(@PathVariable Integer userId, @PathVariable String name) {
        String now = userService.getNow();
        System.out.println("userinfo===>" + name + userId);
        return "查询当前时间" + now;
    }

}
