package com.chen.jason.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {

    private String account;
    private String userName;
    private String name;
    private Integer idcard;
    private String email;
    private String status;
    private String isDelete;
    private Date deleteTime;

}