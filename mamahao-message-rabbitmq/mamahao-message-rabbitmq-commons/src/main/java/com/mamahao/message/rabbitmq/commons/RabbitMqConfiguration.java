package com.mamahao.message.rabbitmq.commons;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/3
 * Time           :   15:11
 * Description    :
 */
@SuppressWarnings("ALL")
@Configuration
@ImportResource({"classpath:spring-boot-rabbitmq-commons.xml"})
public class RabbitMqConfiguration {
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        factory.setAddresses(properties.getAddresses());
//        factory.setUsername(properties.getUsername());
//        factory.setPassword(properties.getPassword());
//        factory.setVirtualHost(properties.getVirtualHost());
//        factory.setPublisherConfirms(properties.isPublisherConfirms());
//        return factory;
//    }

//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Autowired
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
//        return template;
//    }

    @Bean
    @Autowired
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
        return containerFactory;
    }
}
