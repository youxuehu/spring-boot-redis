package com.example.springbootredis.user.controller;

import com.example.springbootredis.user.dao.model.RedisUser;
import com.example.springbootredis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user.json")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(params = "action=insertUser", method = {RequestMethod.GET, RequestMethod.POST})
    public Integer insertUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        RedisUser user = new RedisUser();
        user.setUsername(username);
        user.setPassword(password);
        Integer count = userService.insertUser(user);
        redisTemplate.opsForValue().set("redisUser", user);
        return count;
    }
}
