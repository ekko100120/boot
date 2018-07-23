## MQ专题

### ActiveMQ

###### 关于JMS(Java Message Serive)

**非消息服务架构的弊病：**
```jshelllanguage
1.通信的同步性
client端发起调用后，必须等待server处理完成并返回结果后才能继续执行

2.client 和 server 的生命周期耦合太高

client进程和server服务进程都必须可用，如果server出现问题或者网络故障，那么client端会收到异常

3.点对点通信

client端的一次调用只能发送给某一个单独的服务对象，无法一对多
```

> JMS，即Java Message Service，通过面向消息中间件（MOM：Message Oriented Middleware）的方式很好的解决了上面的问题。
大致的过程是这样的：发送者把消息发送给消息服务器，消息服务器将消息存放在若干队列/主题中，
在合适的时候，消息服务器会将消息转发给接受者。在这个过程中，发送和接受是异步的，也就是发送无需等待，
而且发送者和接受者的生命周期也没有必然关系；在pub/sub模式下，也可以完成一对多的通信，即让一个消息有多个接受者

##### 专业术语
* Provider/MessageProvider：生产者

* Consumer/MessageConsumer：消费者

* PTP：Point To Point，点对点通信消息模型

* Pub/Sub：Publish/Subscribe，发布订阅消息模型

* Queue：队列，目标类型之一，和PTP结合

* Topic：主题，目标类型之一，和Pub/Sub结合

* ConnectionFactory：连接工厂，JMS用它创建连接

* Connnection：JMS Client到JMS Provider的连接

* Destination：消息目的地，由Session创建

* Session：会话，由Connection创建，实质上就是发送、接受消息的一个线程，因此生产者、消费者都是Session创建的



