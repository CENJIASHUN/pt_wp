package com.chen.jason.service;

import com.chen.jason.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetails user);

    UserDetails selectByPrimaryKey(Integer id);

    List<UserDetails> selectAll();

    int updateByPrimaryKey(UserDetails user);
}
