package com.hufei.service.impl;

import com.hufei.mapper.TestMapper;
import com.hufei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: hufei
 * @date: 2020/12/12 17:11
 * @version: 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String getNow() {
        System.out.println("service方法被调用了！");
        String now = testMapper.getNow();
        return now;
    }
}
