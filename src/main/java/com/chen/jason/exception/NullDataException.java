package com.chen.jason.exception;

/**
 * 获取数据为空的异常
 */
public class NullDataException extends BaseException {
    public NullDataException(String message) {
        super(message);
    }

    public NullDataException(Integer state, String message) {
        super(message);
        if (state != null) {
            super.state=state;
            this.state = state;
        }
    }

    protected Integer state = 7777;
}
