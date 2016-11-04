package com.mamahao.message.rabbitmq.producer;

import com.mamahao.message.rabbitmq.commons.bean.RabbitMqProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/3
 * Time           :   15:28
 * Description    :
 */
@Component
public class SimpleProducer implements RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitMqProperties properties;
    private RabbitTemplate template;

    public SimpleProducer(RabbitTemplate template) {
        this.template = template;
        template.setConfirmCallback(this);
    }

    public void sendMessage(String content){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        template.convertAndSend(
                properties.getExchange(),
                properties.getRoutingKey(),
                content,
                correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("correlationData:" + correlationData);
        if(ack){
            System.out.println("消费成功");
        }else {
            System.out.println("消费失败:" + cause);
        }
    }
}
