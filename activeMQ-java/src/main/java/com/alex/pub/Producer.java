package com.alex.pub;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * 发布订阅模式
 * 一对多的生产者
 */
public class Producer {

    public static void main(String[] args) {

        try {
            //tcp://127.0.0.1:61616 默认的链接端口和协议
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            //创建链接
            Connection connection = connectionFactory.createConnection();
            //打开链接
            connection.start();
            //创建session
            //第一参数表示是否开启事务
            //第二个参数消息确认的模式
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //这个topic 可以随便取 但是消费者必须和这个一样
            Topic topic = session.createTopic("topic");
            //创建消息的生产者
            MessageProducer topicProducer = session.createProducer(topic);

            //创建消息的载体
            ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
            //设置消息
            textMessage.setText("hello topic");
            //发送消息
            topicProducer.send(textMessage);
            //释放资源
            topicProducer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

}
