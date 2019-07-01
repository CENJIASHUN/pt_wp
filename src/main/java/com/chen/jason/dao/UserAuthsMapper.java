package com.chen.jason.dao;

import com.chen.jason.model.UserAuths;
import java.util.List;

public interface UserAuthsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAuths record);

    UserAuths selectByPrimaryKey(Integer id);

    List<UserAuths> selectAll();

    int updateByPrimaryKey(UserAuths record);
}