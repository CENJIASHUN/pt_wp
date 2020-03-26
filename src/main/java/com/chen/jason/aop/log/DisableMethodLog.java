package com.chen.jason.aop.log;

import java.lang.annotation.*;

/**
 * @author: yf
 * @description: gcp.aop.log
 * @created on:2019-09-16 10:07
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DisableMethodLog {
}
