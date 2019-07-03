package com.chen.jason.test.DingShiRenWu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created on 2019/7/3. By CenJS
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestScheduleTest {

    @Test
    @Scheduled(cron = "0/60 * * * * ? ")
    public void printDate(){
        System.out.println(new Date().toLocaleString());
    }

    @Test
    @Scheduled(fixedDelay = 1000)  //定时任务1
    public void printXXXXXXX(){
        try{
            Thread.sleep(5000);  //睡眠5秒
            System.out.println("printXXXXXXX"+new Date().toLocaleString()); //打印当前线程名字
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Scheduled(fixedDelay = 1000)  //定时任务2
    public void printYYYYYYY(){
        try{
            Thread.sleep(5000);
            System.out.println("printYYYYYYY"+new Date().toLocaleString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
