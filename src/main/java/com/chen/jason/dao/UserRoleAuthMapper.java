package com.chen.jason.dao;

import com.chen.jason.model.UserRoleAuth;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRoleAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleAuth record);

    UserRoleAuth selectByPrimaryKey(Integer id);

    List<UserRoleAuth> selectAll();

    int updateByPrimaryKey(UserRoleAuth record);
}