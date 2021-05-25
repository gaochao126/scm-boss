package com.superb.user;

import com.superb.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> listUser();

    List<UserEntity> selectUserBySex(int sex);

    void initUserToRedis();

    String getUserFromRedis();
}
