package com.chen.jason.dao;

import com.chen.jason.model.UserDetails;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Component
public interface UserDetailsMapper extends Mapper<UserDetails>, MySqlMapper<UserDetails> {

    List<UserDetails> selectAllUserDetails();

    /** 根据用户名（手机号）查找是否已注册**/
    UserDetails selectByAccount(String account);

    /** 根据手机号和密码进行登录**/
    UserDetails userlogin(String account, String password);
}