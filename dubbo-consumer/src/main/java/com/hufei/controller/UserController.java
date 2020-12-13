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

//    @GetMapping(value = "/findTest/{userId}", produces="text/html;charset=UTF-8")
    @GetMapping(value = "/findTest/{userId}")
    public String method(@PathVariable Integer userId) {
        String now = userService.getNow();
        return "查询当前时间" + now;
    }

}
