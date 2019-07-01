package com.chen.jason.service.impl;

import com.chen.jason.dao.WorldPeaceMapper;
import com.chen.jason.model.WorldPeace;
import com.chen.jason.service.WorldPeaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public class WorldPeaceServiceImpl implements WorldPeaceService {

//    @Autowired
    private WorldPeaceMapper worldPeaceMapper;

    public WorldPeaceMapper getWorldPeaceMapper() {
        return worldPeaceMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return worldPeaceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WorldPeace worldPeace) {
        return worldPeaceMapper.insert(worldPeace);
    }

    @Override
    public WorldPeace selectByPrimaryKey(Integer id) {
        return worldPeaceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WorldPeace> selectAll() {
        return worldPeaceMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(WorldPeace worldPeace) {
        return worldPeaceMapper.updateByPrimaryKey(worldPeace);
    }
}
