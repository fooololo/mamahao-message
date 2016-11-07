package com.mamahao.message.rabbitmq.consumer.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/4
 * Time           :   17:44
 * Description    :
 */
@SpringBootApplication
@ComponentScan({"com.mamahao.message.rabbitmq"})
public class ConsumerApplication implements CommandLineRunner{
    public static void main(String[] args) {
        ConfigurableApplicationContext application = new SpringApplicationBuilder()
                .sources(ConsumerApplication.class)
                .web(false)
                .run(args);
        application.registerShutdownHook();

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ConsumerApplication启动成功");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
