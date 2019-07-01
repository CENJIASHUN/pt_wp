package com.chen.jason.dao;

import com.chen.jason.model.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetails record);

    UserDetails selectByPrimaryKey(Integer id);

    List<UserDetails> selectAllUserDetails();

    int updateByPrimaryKey(UserDetails record);
}