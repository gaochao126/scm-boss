package com.superb.rabbitmq.direct;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queues = "directQueue")
public class DirectReceiver {

    /**
     * 直连交换机，如果存在多个Direct交换机监听器，消息不会被重复消费
     *
     * @param message
     */
    @RabbitHandler
    public void process(Map message) {
        log.info("direct消费者收到消息：{}", JSONObject.toJSON(message));
    }
}
