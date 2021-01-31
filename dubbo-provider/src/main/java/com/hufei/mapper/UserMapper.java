package com.hufei.mapper;

import com.hufei.pojo.UserVO;

import java.util.List;

public interface UserMapper {
    List<UserVO> findUserList();
}