package com.mamahao.message.rabbitmq.producer.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/7
 * Time           :   11:36
 * Description    :
 */
@SpringBootApplication
@ImportResource({"classpath:spring-boot-rabbitmq-producer.xml"})
public class ProducerApplication implements CommandLineRunner,RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate template;

    public static void main(String[] args) {
        ConfigurableApplicationContext application = new SpringApplicationBuilder()
                .sources(ProducerApplication.class)
                .web(false)
                .run(args);
        application.registerShutdownHook();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ProducerApplication启动成功");
        template.setConfirmCallback(this);
        int i = 1000;
        String queue = "demo_msg";
        for (int j = 0; j < i; j++) {
            Object content = "test_demo_msg_" + j;
            CorrelationData cd = new CorrelationData(UUID.randomUUID().toString());
            template.convertAndSend(queue,content,cd);
            System.out.println("send:" + j);
            TimeUnit.SECONDS.sleep(2);
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("ID:" + correlationData.getId());
        if(ack){
            System.out.println("消费成功");
        }else {
            System.out.println("消费失败");
        }
    }
}
