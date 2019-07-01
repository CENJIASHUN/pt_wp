package com.chen.jason.utils;

import java.util.concurrent.TimeUnit;

public class Enumeration {
    public enum RET_CODE{
        ;
        public static final int SUCCESS = 0;
        public static final int FAIL = 1;
    }

    public enum SECRET_KEY{
        ;
        //秘钥
        public static final String KEY = "YN544knjhjUjYN544knjhjUjkj21kj21";
    }

    /** 正则表达式 **/
    public enum Regular{
        ;
        /** 身份证**/
        public static final String idRegular = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
        /** 手机**/
        public static final String phoneRegular = "^(13[0-913[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|17[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9]|19[0|1|2|3|5|6|7|8|9])\\d{8}$";
    }

    /**
     * 用户中心枚举
     */
    public enum UserCenterEnum{

        // 验证码类型 0:注册 1:忘记密码 2:登录 3:修改手机号
        USER_REG("0","USER_REG_TAG_"),USER_LOGIN("2","USER_LOGIN_TAG_");

        private String codeType;

        private String codeTag;

        UserCenterEnum(String codeType,String codeTag){
            this.codeType = codeType;
            this.codeTag = codeTag;
        }

        //患者的角色
        public static final String PATIENT_ROLE = "患者";
        //医生的角色
        public static final String DOCTOR_ROLE = "医生";

        /**
         * 默认token失效时间  （单位小时）
         */
        public static final long DEFAULT_TIMEOUT = 12;

        /**
         * 默认密码
         */
        public static final String DEFAULT_USER_PASSWORD = "123456";


        /**
         * redis默认时间单位：小时
         * @Description
         */
        public static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.HOURS;

        public String getCodeType() {
            return codeType;
        }

        public String getCodeTag() {
            return codeTag;
        }
    }
}
