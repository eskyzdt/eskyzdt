package cn.eskyzdt.modules.rabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amqp")
public class RabbitMQ {

    @Value("${rabbitmq.zeusexchange}")
    private String zeusexchangeAddress;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public void sendMessage() {
        String a = "dsfdsdf";
        byte[] bytes = a.getBytes();
        rabbitTemplate.convertAndSend(zeusexchangeAddress, "",a);
    }

}
