package com.superb.rabbitmq.topic;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RabbitListener(queues = "topic.queue1")
public class TopicReceiverA {

    @RabbitHandler
    public void process1(Map message) {
        log.info("topic接收queue1队列消息：{}", JSONObject.toJSON(message));
    }

}
