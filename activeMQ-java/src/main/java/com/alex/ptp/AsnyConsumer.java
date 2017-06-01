package com.alex.ptp;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * 点对点异步消息消费
 * 推荐使用这种方式
 */
public class AsnyConsumer {

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
            //这个ptp 可以随便取 但是消费者必须和这个一样
            Queue queue = session.createQueue("ptp");
            //创建消息的生产者
            MessageConsumer messageConsumer = session.createConsumer(queue);

            //异步消息的监听器
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        //打印消息内容
                        System.out.println(((ActiveMQTextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            //如果跳出了记得要释放资源
            /*messageConsumer.close();
            session.close();
            connection.close();*/

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
