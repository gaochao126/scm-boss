package com.superb.rabbitmq.fanout;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class FanoutSender {
    @Resource
    RabbitTemplate rabbitTemplate;


    public void send() {
        for (int i = 0; i < 5; i++) {
            // rabbitTemplate.convertSendAndReceive("exchange_fanout", "", "测试发布订阅模型：" + i);
            rabbitTemplate.convertAndSend("fanoutExchange", "", "测试发布订阅模型：" + i, new CorrelationData(UUID.randomUUID().toString()));
        }
    }
}
