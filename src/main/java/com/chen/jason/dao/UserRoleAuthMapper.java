package com.chen.jason.dao;

import com.chen.jason.model.UserRoleAuth;
import com.chen.jason.model.WorldPeace;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Component
public interface UserRoleAuthMapper extends Mapper<UserRoleAuth>, MySqlMapper<UserRoleAuth> {

}