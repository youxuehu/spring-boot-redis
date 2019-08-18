package com.example.springbootredis.experiment.dao.mapper;

import com.example.springbootredis.experiment.dao.model.NodeInstance;
import com.example.springbootredis.experiment.dao.model.NodeInstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NodeInstanceMapper {
    int countByExample(NodeInstanceExample example);

    int deleteByExample(NodeInstanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NodeInstance record);

    int insertSelective(NodeInstance record);

    List<NodeInstance> selectByExample(NodeInstanceExample example);

    NodeInstance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NodeInstance record, @Param("example") NodeInstanceExample example);

    int updateByExample(@Param("record") NodeInstance record, @Param("example") NodeInstanceExample example);

    int updateByPrimaryKeySelective(NodeInstance record);

    int updateByPrimaryKey(NodeInstance record);
}