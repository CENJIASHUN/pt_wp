package com.chen.jason.dao;

import com.chen.jason.model.WorldPeace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;


@Component
public interface WorldPeaceMapper extends Mapper<WorldPeace>, MySqlMapper<WorldPeace> {


}