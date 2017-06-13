package com.alex.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * 监听器类,会在监听到服务器有消息时候回调
 */
public class MyTopicLisdtener implements MessageListener {
    public void onMessage(Message message) {

        TextMessage textMessage= (TextMessage) message;
        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
