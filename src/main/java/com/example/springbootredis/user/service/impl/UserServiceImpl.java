package com.example.springbootredis.user.service.impl;

import com.example.springbootredis.user.dao.mapper.RedisUserMapper;
import com.example.springbootredis.user.dao.model.RedisUser;
import com.example.springbootredis.user.dao.model.RedisUserExample;
import com.example.springbootredis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUserMapper redisUserMapper;

    @Override
    public Integer insertUser(RedisUser user) {
        user.setCreateTime(new Date());
        int count = redisUserMapper.insertSelective(user);
        return count;
    }

    @Override
    public RedisUser queryByIid(Long id) {
        return redisUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RedisUser> queryList(String username) {
        RedisUserExample condition = new RedisUserExample();
        condition.createCriteria().andUsernameEqualTo(username);
        List<RedisUser> redisUsers = redisUserMapper.selectByExample(condition);
        return CollectionUtils.isEmpty(redisUsers) ? new ArrayList<>() : redisUsers;
    }
}
