package com.chen.jason.dao;

import com.chen.jason.model.UserAuths;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Component
public interface UserAuthsMapper extends Mapper<UserAuths>, MySqlMapper<UserAuths> {

}