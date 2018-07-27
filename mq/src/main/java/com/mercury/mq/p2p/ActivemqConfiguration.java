package com.mercury.mq.p2p;


import com.mercury.mq.p2p.service.Consumer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;


/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/18-14:17
 * @Description:
 * @return:
 */
@Configuration
@ComponentScan(basePackages = "com.mercury.mq.p2p")
public class ActivemqConfiguration {

   private final static   String  BROKERURL ="tcp://localhost:61616";
   private final  static String  USERNAME="admin";
   private final  static  String  PASSWORD="admin";


   @Autowired
   @Qualifier(value = "activeMQConnectionFactory")
   public ActiveMQConnectionFactory activeMQConnectionFactory;
   @Autowired
   private JmsTemplate jmsTemplate;

   @Autowired
   private ActiveMQQueue queue;

   @Autowired
   private Consumer consumer;

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

   //2.定义destination：Queue或者Topic
   @Bean (name = "queue")
   public ActiveMQQueue activeMQQueue() {

      return new ActiveMQQueue("消费MQ");
   }
   @Bean(name = "topic")
   public ActiveMQTopic activeMQTopic(){
      return new ActiveMQTopic();
   }


//   3.构造jmsTemplate
   @Bean
   public JmsTemplate jmsTemplate() {
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
      //指定消息传送模式,true表示发布订阅，false表示点对点
      jmsTemplate.setPubSubNoLocal(false);
      return jmsTemplate;
   }

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
       messageListenerContainer.setDestination(queue);
       messageListenerContainer.setMessageListener(messageListener);
       return  messageListenerContainer;
   }



}
