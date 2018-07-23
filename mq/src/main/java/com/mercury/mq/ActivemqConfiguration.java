package com.mercury.mq;


import com.mercury.mq.service.Consumer;
import com.mercury.mq.service.Producer;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-14:17
 * @Description:
 * @return:
 */
@Configuration
public class ActivemqConfiguration {

   private final static   String  BROKERURL ="tcp://localhost:61616";
   private final  static String  USERNAME="admin";
   private final  static  String  PASSWORD="admin";

   @Autowired
   private ActiveMQConnectionFactory activeMQConnectionFactory;
   @Autowired
   private JmsTemplate jmsTemplate;
   @Autowired
   private ActiveMQDestination activeMQQueue;
   @Autowired
   private Consumer consumer;

   @Autowired
   private MessageListenerAdapter messageListener;



//   1. 定义ActiveMQ的ConnectionFactory
   @Bean
   public ActiveMQConnectionFactory activeMQConnectionFactory(){
      ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
      activeMQConnectionFactory.setBrokerURL(BROKERURL);
      activeMQConnectionFactory.setUserName(USERNAME);
      activeMQConnectionFactory.setPassword(PASSWORD);
      return activeMQConnectionFactory;
   }

   //2.定义destination：Queue或者Topic
   @Bean //(name = "mqDestination")
   public ActiveMQQueue activeMQQueue() {
      return new ActiveMQQueue();
   }
   @Bean
   public ActiveMQTopic activeMQTopic(){
      return new ActiveMQTopic();
   }

//   3.构造jmsTemplate
   @Bean
   public JmsTemplate jmsTemplate() {
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
      return jmsTemplate;
   }
//// 4.定义生产者
//   @Bean
//   public Producer producer(){
//      Producer  producer = new Producer();
//      producer.setTemplate(jmsTemplate);
//      producer.setDestination((Destination) activeMQQueue);
//      return  producer;
//   }
////   构造消费者bean
//   @Bean
//   public Consumer consumer(){
//      Consumer consumer =new Consumer();
//      consumer.setId(1);
//      return  consumer;
//   }
   @Bean
   public MessageListenerAdapter messageListener(){
      MessageListenerAdapter adapter = new MessageListenerAdapter(consumer);
      adapter.setDefaultListenerMethod("consume");
      return adapter;
   }

   @Bean
   public DefaultMessageListenerContainer messageListenerContainer(){
      DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
       messageListenerContainer.setConnectionFactory(activeMQConnectionFactory);
       messageListenerContainer.setDestination(activeMQQueue);
       messageListenerContainer.setMessageListener(messageListener);
       return  messageListenerContainer;
   }



}
