package com.alex.pub;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 *
 * 一对多的消息消费者
 * 同步接收
 *
 *
 */
public class Consumer {

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
            MessageConsumer topicConsumer = session.createConsumer(topic);
            //循环阻塞等待消息
            while (true){
                Message message = topicConsumer.receive(10000);
                if (message!=null){
                    //打印消息内容
                    System.out.println(((ActiveMQTextMessage) message).getText());
                }

            }

            //如果跳出了记得要释放资源
            /*topicConsumer.close();
            session.close();
            connection.close();*/




        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
