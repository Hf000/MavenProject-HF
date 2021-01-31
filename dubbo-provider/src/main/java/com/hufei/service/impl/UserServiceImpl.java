package com.hufei.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.hufei.mapper.TestMapper;
import com.hufei.mapper.UserMapper;
import com.hufei.pojo.UserVO;
import com.hufei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getNow() {
        System.out.println("service方法被调用了！");
        String now = testMapper.getNow();
        return now;
    }

    @Override
    public List<UserVO> findUserList() {
        PageInfo<UserVO> objectPageInfo = PageMethod.startPage(1, 10).doSelectPageInfo(() -> userMapper.findUserList());
        return objectPageInfo.getList();
    }
}
