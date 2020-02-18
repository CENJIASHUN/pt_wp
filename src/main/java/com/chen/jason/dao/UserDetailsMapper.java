package com.chen.jason.dao;

import com.chen.jason.model.UserDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Component
public interface UserDetailsMapper extends Mapper<UserDetails> {

    /** 查找所有用户信息 **/
    List<UserDetails> selectAllUserDetails();

    /** 根据用户名（手机号）查找是否已注册**/
    UserDetails selectByAccount(@Param("account") String account);

    /** 根据手机号和密码进行登录**/
    UserDetails userlogin(@Param("account") String account, @Param("password") String password);
}