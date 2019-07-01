package com.chen.jason.dto;

import lombok.Data;

import java.io.Serializable;
import com.chen.jason.utils.Enumeration;
import tk.mybatis.mapper.util.StringUtil;

@Data
public class ResultBean<T> implements Serializable {

    private int ret_code;

    private T ret_data;

    private String ret_info;

    public ResultBean(T ret_data) {
        this.ret_code = 0;
        this.ret_info = "成功";
        this.ret_data = ret_data;
    }

    public ResultBean() {
    }

    public ResultBean(int ret_code, String ret_info, T ret_data) {
        this.ret_code = ret_code;
        this.ret_data = ret_data;
//        if (ret_code == Enumeration.RET_CODE.FAIL){ }
        if (StringUtil.isNotEmpty(ret_info)){
            this.ret_info = "失败";
        }
    }

    public ResultBean<T> setRetInfo(String ret_info){
        this.ret_info = ret_info;
        return this;
    }
    public ResultBean<T> setRetCode(int ret_code){
        this.ret_code = ret_code;
        return this;
    }
    public ResultBean<T> setRetData(T ret_data){
        this.ret_data = ret_data;
        return this;
    }
}
