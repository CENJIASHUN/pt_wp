package com.chen.jason.controller;

import com.chen.jason.dto.ResultBean;
import com.chen.jason.model.UserDetails;
import com.chen.jason.service.UserDetailsService;
import com.chen.jason.utils.AesEncryptUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created on 2019/3/30. By CenJS
 */
@Api(tags = "【用户详情UserDetails】")
@RestController
@RequestMapping("/UserDetails")
public class UserDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsController.class);

    @Autowired
    private UserDetailsService userDetailsService;


    @ApiOperation(value = "获取所有用户的详细信息")
    @PostMapping("/selectAllUserDetails")
    public ResultBean<List<UserDetails>> selectAllUserDetails() throws Exception {
        List<UserDetails> userDetailsList = userDetailsService.selectAllUserDetails();
        return new ResultBean<>(userDetailsList);
    }

    @ApiOperation(value = "加密-获取所有用户信息")
    @PostMapping("/selectAllUserAllByAES")
    public ResultBean<String> selectAllUserAllByAES() throws Exception {
        List<UserDetails> result = userDetailsService.selectAllUserDetails();
        JSONArray result2 = JSONArray.fromObject(result);
        String result0 = AesEncryptUtil.encrypt(result2.toString());
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result0);
        System.out.println(AesEncryptUtil.desEncrypt(result0));
        return new ResultBean<>(result0);
    }

    @ApiOperation(value = "查询")
    @PostMapping("/selectUserById")
    public ResultBean<UserDetails> selectUserById(
       @ApiParam(name = "id", value = "id", required = true) @RequestParam(value = "id") Integer id
    ){
        UserDetails user = userDetailsService.selectByPrimaryKey(id);
        LOG.info(String.valueOf(user));
        return new ResultBean<>(user);
    }

}
