package com.mamahao.message.rabbitmq.consumer.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.PrintStream;

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
        new SpringApplicationBuilder(ConsumerApplication.class)
                .web(false)
                .headless(true)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ConsumerApplication启动成功");
    }

    @Bean
    public PrintStream printStream() {
        return System.out;
    }

}
