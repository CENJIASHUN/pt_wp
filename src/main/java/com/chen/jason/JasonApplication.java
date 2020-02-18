package com.chen.jason;


import com.chen.jason.stu.thread.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.chen.jason")
@MapperScan("com.chen.jason.dao")
@EnableScheduling
@EnableAsync
public class JasonApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JasonApplication.class, args);
    }


    @Bean
    public SpringContextUtil getSpringContextUtil() {
        return new SpringContextUtil();
    }
}
