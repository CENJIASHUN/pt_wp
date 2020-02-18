package com.chen.jason.stu.task;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created on 2019/7/3. By CenJS
 */
//@Component
public class TestSchedule {

    @Scheduled(fixedDelay = 1000)
    public void printDate(){
        System.out.println("Task executed at " + LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 5000)  //定时任务1
    public void printXXXXXXX(){
        try{
//            Thread.sleep(5000);  //睡眠5秒
            System.out.println("printXXXXXXX"+new Date().toLocaleString()); //打印当前线程名字
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(fixedRate = 5000)  //定时任务2
    public void printYYYYYYY(){
        try{
//            Thread.sleep(5000);
            System.out.println("printYYYYYYY"+new Date().toLocaleString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
/**
 * @Scheduled有三种定时任务的执行方式:fixedDelay、fixedRate、corn表达式
 * fixedDelay：指定两次任务执行的时间间隔(毫秒):前一次任务结束与下一个任务开始的间隔。
 * 如：@Scheduled(fixedDelay = 5*1000 )，表示第一个任务结束后，过5秒后，开始第二个任务。
 *
 * fixedRate：指定两次任务执行的时间间隔(毫秒):前一个任务开始与下一个任务开始的间隔。
 * 如：@Scheduled(fixedRate= 5*1000 )，表示第一个任务开始后(第一个任务执行时间小于5秒)，第一个任务开始后的第6秒，开始第二个任务。如果第一个任务执行时间大于5秒，第一个任务结束后，直接开始第二个任务。
 *
 * cron：使用表达是进行任务的执行，例如：@Scheduled(cron = "0/15 * * * * ? ")每隔15秒执行一次
 *
 */