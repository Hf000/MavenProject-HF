package com.hufei.service;

import com.hufei.pojo.UserVO;

import java.util.List;

/**
 * @description:
 * @author: hufei
 * @date: 2020/12/12 17:12
 * @version: 1.0.0
 */
public interface IUserService {

    String getNow();

    List<UserVO> findUserList();
}
