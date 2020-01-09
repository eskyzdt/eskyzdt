package cn.eskyzdt.modules.rabbitMQ;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

@Component
@RabbitListener(queues = "cms.queuea")
public class MessageConsumer implements MessageListener {



    @Override
    public void onMessage(Message message) {
        System.out.println("receive message:{}"+message.getBody());
        try {
            String s = new String(message.getBody(), "UTF-8");
            System.out.println("------>MQ接收到的数据："+s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv)
            throws java.io.IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("193.168.1.214");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5672);
        factory.setVirtualHost("cms.host");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

      /*  channel.queueDeclare("cms.queuea", false, false, false, null);
*/
        Consumer consumer = new DefaultConsumer(channel) {
            private final Logger logger = LoggerFactory.getLogger(this.getClass());

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(message);
            }
        };
        channel.basicConsume("cms.queuea", true, consumer);

    }

    /*@RabbitHandler
    public void process(String message) {
        logger.info("接收处理队列A当中的消息： " + new String(message));
        logger.error("dsfsdfsdfsdfsdfs");
    }*/

}
