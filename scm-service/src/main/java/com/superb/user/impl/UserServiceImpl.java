package com.superb.user.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.superb.mapper.UserMapper;
import com.superb.model.UserEntity;
import com.superb.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,  String> redisTemplate;

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

    @Override
    public void initUserToRedis() {
        UserEntity user = new UserEntity();
        user.setId(10000L);
        user.setUserAddress("redis测试对象");
        user.setUserName("redis");
        user.setUserSex(1);
        redisTemplate.opsForValue().set("redis", JSONObject.toJSONString(user));

    }

    @Override
    public String getUserFromRedis() {
        String str = redisTemplate.opsForValue().get("redis");
        return str;
    }


}
