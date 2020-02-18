package com.chen.jason.exception;

import lombok.Data;

/**
 * 自定义异常的基类
 */
@Data
public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }


    public BaseException(Integer state, String message) {
        super(message);
        if (state != null) {
            this.state = state;
        }
    }

    protected Integer state = 8888;

}
