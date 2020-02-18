package com.chen.jason.stu.mq.consumer;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 2020/2/3. By CenJS
 */
@Component
@Slf4j
public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {

    /**
     *  默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息<br/>
     *  不要抛异常，如果没有return CONSUME_SUCCESS ，consumer会重新消费该消息，直到return CONSUME_SUCCESS
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if(CollectionUtils.isEmpty(msgs)){
            log.info("接受到的消息为空，不处理，直接返回成功");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        int i=0;
        try {
            MessageExt messageExt = msgs.get(0);
            log.info("接受到的消息为："+messageExt.toString());
            if (messageExt.getTopic().equals("gcpSubjectStatistic")) {
                if (messageExt.getTags().equals("cjs")) {
                    log.info("接收消息！go！go！go！go！go！go！");
                    // 获取该消息重试次数
                    int reconsume = messageExt.getReconsumeTimes();
                    if (reconsume > 0) {
                        // 消息已经重试了3次，如果不需要再次消费，则返回成功
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    // 处理对应的业务逻辑
                    log.info("处理对应的业务逻辑");
                }
            } else if (messageExt.getTopic().equals("check")) {
                if (messageExt.getTags().equals("cjs")) {
                    log.info("另一个topic！go！go！go！go！go！go！");
                    // 获取该消息重试次数
                    int reconsume = messageExt.getReconsumeTimes();
                    if (reconsume > 0) {
                        // 消息已经重试了3次，如果不需要再次消费，则返回成功
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    // 处理对应的业务逻辑
                    log.info("另一个topic-处理对应的业务逻辑",i++);
                    if (i==1){
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                }
            }
        } catch (Exception e){
            log.error("MQ消息处理异常：", e);
        }
        // 如果没有return success ，consumer会重新消费该消息，直到return success
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}