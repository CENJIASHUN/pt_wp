package com.chen.jason;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.chen.jason")
@MapperScan("com.chen.jason.dao")
@EnableScheduling
public class JasonApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JasonApplication.class, args);
    }

}
