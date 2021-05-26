package com.superb.controller.rabbitmq;

import com.superb.rabbitmq.direct.DirectSender;
import com.superb.rabbitmq.fanout.FanoutSender;
import com.superb.rabbitmq.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @Author: qjc
 * @Date: 2019/12/6
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class MqSenderController {

    /**
     * rabbitMQ 的核心就是  交换器,路由键,队列;
     * <p>
     * 消息来了之后,会发送到交换器,交换器将根据路由键将消息发送到相对应的队列里面去!
     * <p>
     * 消息不用关系到达了那个队列.只需要带着自己的路由键到了交换器就可以了,交换器会帮你把消息发送到指定的队列里面去!
     */

    @Autowired
    private FanoutSender sender;

    @Autowired
    private DirectSender directSender;

    @Autowired
    private TopicSender topicSender;

    @RequestMapping(value = "/fanout/sender", method = {RequestMethod.GET})
    public void fanoutSender() {
        sender.send();
    }

    @RequestMapping(value = "/direct/sender", method = {RequestMethod.GET})
    public void directSender() {
        directSender.send();
    }

    @RequestMapping(value = "/topic/sender1", method = {RequestMethod.GET})
    public void topicSender1() {
        topicSender.send1();
    }

    @RequestMapping(value = "/topic/sender2", method = {RequestMethod.GET})
    public void topicSender2() {
        topicSender.send2();
    }

}
