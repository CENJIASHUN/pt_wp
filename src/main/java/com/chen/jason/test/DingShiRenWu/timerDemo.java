package com.chen.jason.test.DingShiRenWu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer定时任务
 * Created on 2019/7/3. By CenJS
 */
public class timerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        timer.scheduleAtFixedRate(new MyTask(),calendar.getTime(),1000);
    }
}

class MyTask extends TimerTask{
    @Override
    public void run(){
        System.out.println("execute time start is : "+
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(this.scheduledExecutionTime()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
