package com.example.springbootredis.user.dao.mapper;

import com.example.springbootredis.user.dao.model.RedisUser;
import com.example.springbootredis.user.dao.model.RedisUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedisUserMapper {
    int countByExample(RedisUserExample example);

    int deleteByExample(RedisUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RedisUser record);

    int insertSelective(RedisUser record);

    List<RedisUser> selectByExample(RedisUserExample example);

    RedisUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RedisUser record, @Param("example") RedisUserExample example);

    int updateByExample(@Param("record") RedisUser record, @Param("example") RedisUserExample example);

    int updateByPrimaryKeySelective(RedisUser record);

    int updateByPrimaryKey(RedisUser record);
}