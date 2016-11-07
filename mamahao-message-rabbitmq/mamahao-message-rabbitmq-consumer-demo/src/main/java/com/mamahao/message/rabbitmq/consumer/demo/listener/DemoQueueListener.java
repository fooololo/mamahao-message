package com.mamahao.message.rabbitmq.consumer.demo.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/4
 * Time           :   17:46
 * Description    :
 */
public class DemoQueueListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        System.out.println("message:" + message.getBody());
        System.out.println("messageValue:" + new String(message.getBody()));
    }
}
