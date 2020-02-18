package com.chen.jason.service;

import com.chen.jason.dao.UserDetailsMapper;
import com.chen.jason.dao.WorldPeaceMapper;
import com.chen.jason.model.UserDetails;
import com.chen.jason.model.WorldPeace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class AsyncMethondService {

    @Autowired
    private WorldPeaceMapper worldPeaceMapper;

    @Async
    public void testAsyncMethond(List<WorldPeace> list, Integer startIndex, Integer endIndex) {
        long start = System.currentTimeMillis();
        System.out.println("异步调用开始");
        List<WorldPeace> subList = list.subList(startIndex, endIndex);
        for (WorldPeace tmp : subList) {
            worldPeaceMapper.insert(tmp);
        }
        Long timeConsuming = System.currentTimeMillis() - start;
        System.out.println("异步调用结束" + ":" + subList + "用时:" + timeConsuming);

    }
}
