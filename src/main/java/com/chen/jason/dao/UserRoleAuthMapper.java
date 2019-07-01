package com.chen.jason.dao;

import com.chen.jason.model.UserRoleAuth;
import java.util.List;

public interface UserRoleAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleAuth record);

    UserRoleAuth selectByPrimaryKey(Integer id);

    List<UserRoleAuth> selectAll();

    int updateByPrimaryKey(UserRoleAuth record);
}