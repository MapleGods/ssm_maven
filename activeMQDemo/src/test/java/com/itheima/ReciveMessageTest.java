package com.itheima;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class ReciveMessageTest {
    @Test
    public void testRecive() throws JMSException, InterruptedException {
        //1, 创建连接工厂                          tcp: tcp协议
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.133:61616");
        //2 创建连接对象
        Connection connection = connectionFactory.createConnection();
        //3, 开启连接
        connection.start();
        //4, 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5, 创建目的地
//        Queue queue = session.createQueue("test-queue");
        //5
        Topic topic = session.createTopic("test-topic");
        //6, 创建一个消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //7, 获取消息
        //7.1  receive  测试时使用     2. 使用设置一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //有消息的时候执行这个逻辑
                if (message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String text = textMessage.getText();
                        System.out.println(text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread.sleep(10000);
        consumer.close();
        session.close();
        connection.close();
    }
}
