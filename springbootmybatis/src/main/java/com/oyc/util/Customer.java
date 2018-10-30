package com.oyc.util;

import com.rabbitmq.client.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Customer  {
    private final static String QUEUE_NAME = "queue01";

   // @Autowired
    //private ConnectionFactory factory;

    @Test
    public void receive() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setVirtualHost("francis01");
            factory.setHost("127.0.0.1");
            factory.setPort(5672);
            factory.setUsername("root");
            factory.setPassword("root");
            //创建一个新的连接
            Connection connection = factory.newConnection();
            // 从连接中创建通道
            Channel channel = connection.createChannel();
            System.out.println(channel.getChannelNumber());
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("Customer Waiting Received messages");

            //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
            // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Customer Received '" + message + "'");
                }
            };
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
