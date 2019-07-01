package com.chen.jason.dao;

import com.chen.jason.model.UserDetails;
import java.util.List;

public interface UserDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetails record);

    UserDetails selectByPrimaryKey(Integer id);

    List<UserDetails> selectAll();

    int updateByPrimaryKey(UserDetails record);
}