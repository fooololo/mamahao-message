package com.mamahao.message.rabbitmq.producer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/4
 * Time           :   16:47
 * Description    :
 */
@Configuration
@ImportResource({"classpath:spring-boot-rabbitmq-producer.xml"})
public class RabbitMqProducerConfiguration {
}
