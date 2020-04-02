package cn.eskyzdt.modules.rabbitMQ;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.print.DocFlavor;

@RestController
@RequestMapping("/amqp")
public class RabbitMQ {

    @Value("${rabbitmq.exchange}")
    private String zeusexchangeAddress;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public void sendMessage() {
        String a = "dsfdsdf";
        byte[] bytes = a.getBytes();
        rabbitTemplate.convertAndSend(zeusexchangeAddress, "add",a);
    }
    @RequestMapping("/sendObj")
    public void sendObj() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa","ddd");
        String a = "{\"encrypt\":{\"driverPhone\":\"18666820812\",\"id\":85,\"imageObj\":\"etdy@-@jwrwe\",\"remarks\":\"路上\",\"status\":\"异常上报\",\"waybillNumber\":\"F20200320141348521920\",\"receiptTime\":\"2009-12-12 11:11:11\"}}";
        rabbitTemplate.convertAndSend( "cms.queue.zeus.report",a);
    }

    @RequestMapping("/sendObj2")
    public void sendObj2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa","ddd");
        String a = "{\"encrypt\":{\"driverPhone\":\"18666820812\",\"id\":85,\"imageObj\":\"etdy@-@jwrwe\",\"remarks\":\"路上\",\"status\":\"上传回单\",\"waybillNumber\":\"F20200320141348521920\",\"receiptTime\":\"2009-12-12 11:11:11\"}}";
        rabbitTemplate.convertAndSend( "cms.queue.zeus.report",a);
    }

     @RequestMapping("/sendUPT")
    public void sendUPT() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa","ddd");
         String a = "{\"encrypt\":[{\"batchNumber\":\"7092b01b56742a599f2e364ae9938bc8\",\"carNumber\":\"贵GMB954\",\"collectTime\":\"2020-03-17 10:13:56\",\"createTime\":1584354086000,\"driverPhone\":\"18705217576\",\"hasReceipt\":\"无回单\",\"id\":27,\"inputTime\":\"2020-03-16 18:00:02\",\"nowPay\":10.00,\"paymentType\":\"三段付\",\"platformCompanyCode\":\"a77085cdc792ef716830b5dc76d101b0\",\"platformCompanyName\":\"一级会员的客户呀\",\"replaceCost\":0.00,\"replaceGoodsPayment\":0.00,\"reserveTime\":\"\",\"source\":\"2\",\"status\":\"运输中\",\"tailPay\":10.00,\"takeGoodsType\":\"0\",\"toPay\":10.00,\"updateTime\":1584354086000,\"waybillCost\":30.00,\"waybillNumber\":\"Y20200316180001640192\"}]}";
        rabbitTemplate.convertAndSend( "cms.queue.zeus.update",a);
    }
}
