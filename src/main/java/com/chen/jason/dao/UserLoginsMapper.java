package com.chen.jason.dao;

import com.chen.jason.model.UserLogins;
import java.util.List;

public interface UserLoginsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLogins record);

    UserLogins selectByPrimaryKey(Integer id);

    List<UserLogins> selectAll();

    int updateByPrimaryKey(UserLogins record);
}