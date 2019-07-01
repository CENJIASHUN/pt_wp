package com.chen.jason.dao;

import com.chen.jason.model.WorldPeace;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorldPeaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorldPeace record);

    WorldPeace selectByPrimaryKey(Integer id);

    List<WorldPeace> selectAll();

    int updateByPrimaryKey(WorldPeace record);
}