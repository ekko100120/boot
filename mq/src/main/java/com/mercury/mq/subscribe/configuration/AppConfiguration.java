package com.mercury.mq.subscribe.configuration;


import com.mercury.mq.subscribe.service.Subcriber;
import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/27-14:16
 * @Description:
 * @return:
 */
@Configuration
@ComponentScan(basePackages = "com.mercury.mq.subscribe")
public class AppConfiguration {

   private final static   String  BROKERURL ="tcp://localhost:61616";
   private final  static String  USERNAME="admin";
   private final  static  String  PASSWORD="admin";


   @Autowired
   @Qualifier(value = "activeMQConnectionFactory")
   public ActiveMQConnectionFactory mqConnectionFactory;

   @Autowired
   @Qualifier("springFactory")
   public ConnectionFactory springConnectionFactory;
   @Autowired
   private JmsTemplate jmsTemplate;

   @Autowired
   private Subcriber subcriber;
   @Autowired
   @Qualifier("topic")
   private ActiveMQDestination topicDestination;

   @Autowired
   private MessageListenerAdapter messageListener;

   //   1. 定义ActiveMQ的ConnectionFactory
   @Bean(name = "activeMQConnectionFactory")
   public ActiveMQConnectionFactory activeMQConnectionFactory(){
	  ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
	  activeMQConnectionFactory.setBrokerURL(BROKERURL);
	  activeMQConnectionFactory.setUserName(USERNAME);
	  activeMQConnectionFactory.setPassword(PASSWORD);
	  activeMQConnectionFactory.setTrustAllPackages(true);
	  return activeMQConnectionFactory;
   }

   /**************************************************************************
   1. Spring提供的ConnectionFactory只是Spring用于管理ConnectionFactory的，
   真正产生到JMS服务器链接的ConnectionFactory还得是由JMS服务厂商提供，
   并且需要把它注入到Spring提供的ConnectionFactory中。我们这里使用的是ActiveMQ实现的JMS，
   所以在我们这里真正的可以产生Connection的就应该是由ActiveMQ提供的ConnectionFactory。
	*******************************************************************************/

   @Bean(name = "springFactory")
   @Primary
   public CachingConnectionFactory connectionFactory(){
      CachingConnectionFactory  factory = new CachingConnectionFactory(mqConnectionFactory);
      factory.setSessionCacheSize(100);
      factory.setCacheConsumers(true);
      factory.setCacheProducers(true);
      return factory;
   }

   //2.定义destination：Queue或者Topic
//   @Bean (name = "queue")
//   public ActiveMQQueue activeMQQueue() {
//	  return new ActiveMQQueue("消费MQ");
//   }
   @Bean(name = "topic")
   public ActiveMQTopic activeMQTopic(){
	  return new ActiveMQTopic("topic");
   }




   //   3.构造jmsTemplate
   @Bean
   public JmsTemplate jmsTemplate() {
	  JmsTemplate jmsTemplate = new JmsTemplate();
	  jmsTemplate.setConnectionFactory(springConnectionFactory);
	  //指定消息传送模式,true表示发布订阅，false表示点对点
	  jmsTemplate.setPubSubNoLocal(true);
	  //两个功能一样？？
	  //jmsTemplate.setPubSubDomain(true);
	  return jmsTemplate;
   }

   //MessageListener适配器
   @Bean
   public MessageListenerAdapter messageListener(){
	  MessageListenerAdapter adapter = new MessageListenerAdapter(subcriber);
	  adapter.setDefaultListenerMethod("subscribe");
	  return adapter;
   }


   //定义topic监听器
   @Bean
   public DefaultMessageListenerContainer messageListenerContainer(){
	  DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
	  messageListenerContainer.setConnectionFactory(springConnectionFactory);
	  messageListenerContainer.setDestination(topicDestination);
	  messageListenerContainer.setMessageListener(messageListener);
	  return  messageListenerContainer;
   }


}
