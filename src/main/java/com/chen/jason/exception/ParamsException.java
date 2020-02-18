package com.chen.jason.exception;

/**
 * 参数校验异常
 */
public class ParamsException extends BaseException {
    public ParamsException(String message) {
        super(message);
    }

    public ParamsException(Integer state, String message) {
        super(message);
        if (state != null) {
            super.state = state;
            this.state = state;
        }
    }

    protected Integer state = 6666;
}
