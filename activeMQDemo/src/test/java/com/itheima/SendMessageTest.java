package com.itheima;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

//消息生产者
public class SendMessageTest {
    @Test
    public void sendMessage() throws JMSException {
        //1, 创建连接工程 连接到mq的服务器上
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.133:61616");
        //2, 创建连接
        Connection connection = connectionFactory.createConnection();
        //3, 开启连接
        connection.start();
        //4, 创建session对象(会话)
        //4.1 参数  表示是否开启分布式事务  一般我们是否false( 分布式事务很麻烦, 例如跨银行转账时需要)
        //4.2 参数 表示消息的应答模式  两种: 手动应答, 自动应答. 一般使用自动应答(只有不开启分布式事务时才有用)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5, 创建消息内容; 相当于写信件
        TextMessage textMessage = session.createTextMessage("消息测试");
        //6, 创建一个目的地destination(邮筒) 点对点形式的queue;
//        Queue queue = session.createQueue("test-queue");

        //6, 创建一个目的地destination发布和订阅模式(topic)
        Topic topic = session.createTopic("test-topic");
        //7. 创建一个生成者(投递信), 送信人员
        MessageProducer producer = session.createProducer(topic);
        //8, 发送消息
        producer.send(textMessage);
        //9 关闭资源
        producer.close();
        session.close();
        connection.close();

    }
}
