package com.chen.jason.service;

import com.chen.jason.dao.WorldPeaceMapper;
import com.chen.jason.model.WorldPeace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public class WorldPeaceService {
    @Autowired
    private WorldPeaceMapper worldPeaceMapper;
    
    public int deleteByPrimaryKey(Integer id) {
        return worldPeaceMapper.deleteByPrimaryKey(id);
    }

    public int insert(WorldPeace worldPeace) {
        return worldPeaceMapper.insert(worldPeace);
    }

    public WorldPeace selectByPrimaryKey(Integer id) {
        return worldPeaceMapper.selectByPrimaryKey(id);
    }

    public List<WorldPeace> selectAll() {
        return worldPeaceMapper.selectAll();
    }

    public int updateByPrimaryKey(WorldPeace worldPeace) {
        return worldPeaceMapper.updateByPrimaryKey(worldPeace);
    }

}
