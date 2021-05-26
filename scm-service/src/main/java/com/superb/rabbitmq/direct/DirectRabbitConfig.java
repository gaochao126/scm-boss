package com.superb.rabbitmq.direct;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    //创建队列
    @Bean
    public Queue directQueue() {
        return new Queue("directQueue");
    }


    /**
     * 交换机说明:
     * durable="true" rabbitmq重启的时候不需要创建新的交换机
     * auto-delete 表示交换机没有在使用时将被自动删除 默认是false
     * direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     * topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     * fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange", true, false);
    }

    /**
     * 绑定队列与交换机
     *
     * @return
     */
    @Bean
    public Binding bindingDirectExchange() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct.key");
    }
}
