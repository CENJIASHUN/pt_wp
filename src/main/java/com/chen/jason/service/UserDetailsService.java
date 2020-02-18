package com.chen.jason.service;

import com.chen.jason.dao.UserDetailsMapper;
import com.chen.jason.model.UserDetails;
import org.apache.ibatis.annotations.Param;
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

    public UserDetails selectUserById(Integer id){
        UserDetails userDetails = new UserDetails();
        userDetails.setId(id);
        return userDetailsMapper.selectOne(userDetails);
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
        return userDetailsMapper.insertSelective(userDetails);
    }

    public UserDetails selectByAccount(String account) {
        return userDetailsMapper.selectByAccount(account);
    }

}
