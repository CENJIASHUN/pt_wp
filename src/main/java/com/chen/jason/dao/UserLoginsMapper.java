package com.chen.jason.dao;

import com.chen.jason.model.UserLogins;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface UserLoginsMapper extends Mapper<UserLogins>, MySqlMapper<UserLogins> {

}