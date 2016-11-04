package com.mamahao.message.rabbitmq.consumer.demo.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/4
 * Time           :   17:46
 * Description    :
 */
@Component
public class DemoListener  implements MessageListener{
    @Override
    public void onMessage(Message message) {
        System.out.println("message:" + message.getBody());
    }
}
