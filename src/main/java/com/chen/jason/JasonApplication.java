package com.chen.jason;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.chen.jason")
@MapperScan("com.chen.jason.dao")
public class JasonApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JasonApplication.class, args);
    }

}
