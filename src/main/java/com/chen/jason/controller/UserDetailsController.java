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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created on 2019/3/30. By CenJS
 */
@Api(tags = "【用户详情UserDetails】")
//@RestController
@Controller
@RequestMapping("/UserDetails")
public class UserDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsController.class);

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping("/helloWord")
    public String hello() {
        return "thymeleaf/HelloWord";
    }

    @ApiOperation(value = "登录")
    @GetMapping("/userLogin")
    public String userLogin(@RequestParam("account") String account,
                                  @RequestParam("password") String password,ModelMap map) {
        LOG.info("账号密码"+account+password);
        UserDetails userDetails = userDetailsService.userLogin(account, password);
        System.out.println(userDetails);
        if (userDetails!=null){
            map.addAttribute("name",userDetails.getUserName());
            return "thymeleaf/Hello";
        }
        return  "thymeleaf/HelloWord";
    }

    @ApiOperation(value = "注册")
    @GetMapping("/userRegister")
    public String userRegister(
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("username") String username,
//            @RequestParam("code") String code,
            ModelMap map
    ) {
        UserDetails localUser = userDetailsService.selectByAccount(account);
        if (localUser!=null){
            ResultBean resultBean = new ResultBean();
            resultBean.setRet_code(1);
            resultBean.setRet_info("该手机号已注册!");
            map.addAttribute("resultBean",resultBean);
            return "thymeleaf/Hello";
        }else {
            UserDetails userDetails = new UserDetails();
            userDetails.setAccount(account);
            userDetails.setPassword(password);
            userDetails.setUserName(username);
            System.out.println(userDetails);
            userDetailsService.userRegister(userDetails);
            System.out.println(userDetails);
            map.addAttribute("name",userDetails.getUserName());
            return "thymeleaf/Hello";
        }
    }

    @ApiOperation(value = "获取所有用户的详细信息")
    @PostMapping("/selectAllUserDetails")
    @ResponseBody
    public ResultBean<List<UserDetails>> selectAllUserDetails(){
        List<UserDetails> userDetailsList = userDetailsService.selectAllUserDetails();
        return new ResultBean<>(userDetailsList);
    }

    @ApiOperation(value = "加密-获取所有用户信息")
    @PostMapping("/selectAllUserAllByAES")
    @ResponseBody
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
