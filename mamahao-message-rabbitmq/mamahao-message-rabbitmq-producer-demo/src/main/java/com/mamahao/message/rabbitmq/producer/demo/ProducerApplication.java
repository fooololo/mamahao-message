package com.mamahao.message.rabbitmq.producer.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/7
 * Time           :   11:36
 * Description    :
 */
@SpringBootApplication
@ComponentScan({"com.mamahao.message.rabbitmq"})
public class ProducerApplication implements CommandLineRunner{
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
        int i = 1000;
        for (int j = 0; j < i; j++) {
            template.convertAndSend("demo_msg","test_demo_msg_" + j);
            System.out.println("send:" + j);
            TimeUnit.SECONDS.sleep(2);
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
