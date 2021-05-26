package com.superb.rabbitmq.topic;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RabbitListener(queues = "topic.queue2")
public class TopicReceiverB {

    @RabbitHandler
    public void process(Map message) {
        log.info("topic接收到消息queue2：{}", JSONObject.toJSON(message));
    }
}
