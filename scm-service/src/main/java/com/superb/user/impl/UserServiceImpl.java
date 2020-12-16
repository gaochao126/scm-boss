package com.superb.user.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.superb.mapper.UserMapper;
import com.superb.model.UserEntity;
import com.superb.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserEntity> listUser() {

        List<UserEntity> list = userMapper.selectList(new QueryWrapper<>());
        return list;
    }

    @Override
    public List<UserEntity> selectUserBySex(int sex) {

        List<UserEntity> userEntities = userMapper.selectUserBySex(sex);
        return userEntities;
    }
}
