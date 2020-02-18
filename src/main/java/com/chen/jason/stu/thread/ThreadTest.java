package com.chen.jason.stu.thread;

import com.chen.jason.dao.WorldPeaceMapper;
import com.chen.jason.model.WorldPeace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.thymeleaf.spring5.context.SpringContextUtils;

import java.util.List;

/**
 * Created on 2020/1/6. By CenJS
 */
@Slf4j
public class ThreadTest implements Runnable {

    private String threadName;
    private List<WorldPeace> list;
    private int startIndex;
    private int endIndex;
    private WorldPeaceMapper worldPeaceMapper;

    public ThreadTest(String threadName, List<WorldPeace> list, int startIndex, int endIndex) {
        this.threadName = threadName;
        this.list = list;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        if (worldPeaceMapper==null){
            worldPeaceMapper = (WorldPeaceMapper)SpringContextUtil.getBean("worldPeaceMapper");
        }
        List<WorldPeace> subList = list.subList(startIndex, endIndex);
        for (WorldPeace tmp : subList) {
            WorldPeace newTmp = new WorldPeace();
            newTmp.setId(tmp.getId());
            newTmp.setName("CJS");
            worldPeaceMapper.updateByPrimaryKey(newTmp);
        }
        System.out.println(threadName + ":" + subList);
    }

}
