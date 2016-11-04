package com.mamahao.message.rabbitmq.consumer.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.*;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/11/3
 * Time           :   17:29
 * Description    :
 */
@SuppressWarnings("ALL")
@Configuration
public class RabbitMqConsumerConfiguration implements BeanDefinitionRegistryPostProcessor{
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();


//    /**
//     * 创建交换机，共四种：
//     *  FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
//     *  HeadersExchange ：通过添加属性key-value匹配
//     *  DirectExchange:按照routingkey分发到指定队列
//     *  TopicExchange:多关键字匹配
//     * @return
//     */
//    @Bean
//    public Exchange directExchange(){
//        return new DirectExchange(properties.getExchange(),true,false);
//    }
//
//    /**
//     * 创建队列
//     * @return
//     */
//    @Bean
//    public Queue queue(){
//        return new Queue(properties.getQueueName(),properties.isDurable());
//    }
//
//    /**
//     * 绑定交换机和队列
//     * @return
//     */
//    @Bean
//    public Binding binding(){
//        return BindingBuilder.bind(queue()).to(directExchange()).with(properties.getRoutingKey()).noargs();
//    }

    //第二调用这个方法
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    //首先调用这个方法
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    //注册BEAN
    private void registryBean(BeanDefinitionRegistry registry,String name,Class<?> clazz){
        AnnotatedBeanDefinition annotatedBeanDefinition  = new AnnotatedGenericBeanDefinition(clazz);

        ScopeMetadata scopeMetadata = scopeMetadataResolver.resolveScopeMetadata(annotatedBeanDefinition);
        annotatedBeanDefinition.setScope(scopeMetadata.getScopeName());

        //生成Bean name
        String beanName = (name != null) ? name : beanNameGenerator.generateBeanName(annotatedBeanDefinition,registry);

        AnnotationConfigUtils.processCommonDefinitionAnnotations(annotatedBeanDefinition);

        //bean注册的holder类
        BeanDefinitionHolder holder = new BeanDefinitionHolder(annotatedBeanDefinition,beanName);

        BeanDefinitionReaderUtils.registerBeanDefinition(holder,registry);
    }
}
