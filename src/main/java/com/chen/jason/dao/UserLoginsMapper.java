package com.chen.jason.dao;

import com.chen.jason.model.UserLogins;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserLoginsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLogins record);

    UserLogins selectByPrimaryKey(Integer id);

    List<UserLogins> selectAll();

    int updateByPrimaryKey(UserLogins record);
}