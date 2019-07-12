package com.chen.jason.service;

import com.chen.jason.dao.UserDetailsMapper;
import com.chen.jason.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    public int deleteByPrimaryKey(Integer id){
        return userDetailsMapper.deleteByPrimaryKey(id);
    }

    public int insert(UserDetails user){
        return userDetailsMapper.insert(user);
    }

    public UserDetails selectByPrimaryKey(Integer id){
        return userDetailsMapper.selectByPrimaryKey(id);
    }

    public List<UserDetails> selectAllUserDetails(){
        return userDetailsMapper.selectAllUserDetails();
    }

    public int updateByPrimaryKey(UserDetails user){
        return userDetailsMapper.updateByPrimaryKey(user);
    }

    public UserDetails userLogin(String account, String password) {
        return userDetailsMapper.userlogin(account,password);
    }

    public int userRegister(UserDetails userDetails) {
        return userDetailsMapper.insert(userDetails);
    }

    public UserDetails selectByAccount(String account) {
        return userDetailsMapper.selectByAccount(account);
    }

}
