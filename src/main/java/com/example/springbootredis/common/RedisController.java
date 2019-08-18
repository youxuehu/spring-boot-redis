package com.example.springbootredis.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/redis.json")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, params = {"action=set"})
    public void set() {
        ValueOperations values = redisTemplate.opsForValue();
        values.set("message", "hello redis");
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, params = {"action=get"})
    public String get() {
        ValueOperations values = redisTemplate.opsForValue();
        String message = (String) values.get("message");
        return message;
    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, params = {"action=push"})
    public Long push() {
        ListOperations list = redisTemplate.opsForList();
        Long rightPush = list.rightPush("names", Arrays.asList("jack", "tom", "rose", "mike"));
        return rightPush;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, params = {"action=range"})
    public List<String> range() {
        ListOperations list = redisTemplate.opsForList();
        List<String> names = (List<String>) list.leftPop("names");
        return names;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, params = {"action=hashSet"})
    public Set hashSet() {
        SetOperations sets = redisTemplate.opsForSet();
        Set address = sets.difference("address", Arrays.asList("拱墅区祥符街道3-1-904", "西湖区转塘街道之江家园2区9-1-1603"));
        return address;
    }
}
