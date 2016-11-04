package com.mamahao.message.rabbitmq.commons.bean;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/3
 * Time           :   15:14
 * Description    :
 */
public interface RabbitMqProperties {
    String  getAddresses();
    String  getUsername();
    String  getPassword();
    String  getVirtualHost();
    boolean isPublisherConfirms();

    String  getExchange();
    String  getRoutingKey();
    String  getQueueName();
    boolean isDurable();

}
