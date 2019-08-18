package com.example.springbootredis.user.service;

import com.example.springbootredis.user.dao.model.RedisUser;

import java.util.List;

public interface UserService {
    Integer insertUser(RedisUser user);

    RedisUser queryByIid(Long id);

    List<RedisUser> queryList(String username);
}
