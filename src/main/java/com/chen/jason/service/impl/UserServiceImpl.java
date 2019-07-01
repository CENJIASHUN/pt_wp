package com.chen.jason.service.impl;

import com.chen.jason.dao.UserDetailsMapper;
import com.chen.jason.model.UserDetails;
import com.chen.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDetailsMapper userDetailsMapper;

    public UserDetailsMapper getUserDetailsMapper() {
        return userDetailsMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return userDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserDetails user){
        return userDetailsMapper.insert(user);
    }

    @Override
    public UserDetails selectByPrimaryKey(Integer id){
        return userDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserDetails> selectAll(){
        return userDetailsMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserDetails user){
        return userDetailsMapper.updateByPrimaryKey(user);
    }
}
