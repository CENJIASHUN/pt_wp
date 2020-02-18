package com.chen.jason.service;

import com.chen.jason.dao.WorldPeaceMapper;
import com.chen.jason.model.WorldPeace;
import com.chen.jason.stu.thread.ThreadTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/3/30. By CenJS
 */
@Service
public class WorldPeaceService {
    @Autowired
    private WorldPeaceMapper worldPeaceMapper;


    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private AsyncMethondService asyncMethondService;

    @Test
    public void testThreads(){
        List<WorldPeace> tmpList = new ArrayList<>();
        for (int i = 0; i < 12000; i++) {
            WorldPeace tmp = new WorldPeace();
            tmp.setIsDelete(0);
            tmp.setName("test"+i);
            tmp.setId(i);
            tmpList.add(tmp);
        }
        int size = tmpList.size();
        int ThreadSize = 10;
        if (ThreadSize > size) {
            ThreadSize = size;
        }
        int num = size / ThreadSize;
        int leftNum = size % ThreadSize;
        int end = 0;
        for (int i = 0; i < ThreadSize; i++) {
            int start = end;
            end = start + num;
            if (i == (ThreadSize - 1)) {
                end = size;
            } else if (i < leftNum) {
                end = end + 1;
            }
            asyncMethondService.testAsyncMethond(tmpList, start, end);
//            threadPoolTaskExecutor.execute(new ThreadTest("线程[" + (i + 1) + "] ", tmpList, start, end));
        }
    }
    public void testThreads1(){
        for (int i = 0; i < 1200; i++) {
            WorldPeace tmp = new WorldPeace();
            tmp.setIsDelete(0);
            tmp.setName("test"+i);
            tmp.setId(i+1201);
            worldPeaceMapper.insert(tmp);
        }
    }
}
