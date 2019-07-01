package com.chen.jason.service;

import com.chen.jason.model.WorldPeace;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public interface WorldPeaceService {

    int deleteByPrimaryKey(Integer id);

    int insert(WorldPeace record);

    WorldPeace selectByPrimaryKey(Integer id);

    List<WorldPeace> selectAll();

    int updateByPrimaryKey(WorldPeace record);
}
