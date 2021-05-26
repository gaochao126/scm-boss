package com.superb.rabbitmq.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class TopicSender {

    @Resource
    RabbitTemplate rabbitTemplate;

    public void send1() {
        String messageId = String.valueOf(UUID.randomUUID());
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("id", messageId);
        manMap.put("user", "topic");
        manMap.put("name", "topic.man");
        manMap.put("age", 1);
        rabbitTemplate.convertAndSend("topic.exchange", "topic.queue1", manMap, new CorrelationData(UUID.randomUUID().toString()));

    }

    public void send2() {
        String messageId = String.valueOf(UUID.randomUUID());
        Map<String, Object> woman = new HashMap<>();
        woman.put("no", messageId);
        woman.put("address", "topic2");
        woman.put("name", "topic.woman");
        woman.put("age", 3);
        rabbitTemplate.convertAndSend("topic.exchange", "topic.queue2", woman, new CorrelationData(UUID.randomUUID().toString()));
    }
}
