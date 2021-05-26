package com.superb.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    //绑定键
    public final static String queue1 = "topic.queue1";
    public final static String queue2 = "topic.queue2";

    // 创建queue
    @Bean
    public Queue firstQueue() {
        return new Queue(queue1);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(queue2);
    }

    // 创建交换器
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic.exchange");
    }

    // 绑定队列与交换器，模糊匹配
    @Bean
    public Binding bindingExchange1() {
        return BindingBuilder.bind(firstQueue()).to(topicExchange()).with("topic.#");
    }

    // 绑定队列与交换器，精确匹配
    @Bean
    public Binding bindingExchange2() {
        return BindingBuilder.bind(secondQueue()).to(topicExchange()).with(queue2);
    }
}
