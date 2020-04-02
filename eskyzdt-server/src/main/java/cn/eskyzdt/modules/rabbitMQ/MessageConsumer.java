package cn.eskyzdt.modules.rabbitMQ;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.common.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@RabbitListener(queues = "zeus.add")
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@RabbitListener(queues = "cms.queue.zeus.update")
    // @RabbitListener(queues = "zeus_waybill_queue")
    //@RabbitListener(queues = "zeus.delete")
    //@RabbitListener(queues = "cms.queue.zeus.report")
    @RabbitHandler
    public void process(String content) {
        System.out.println(content);
        //Object parse = JSONObject.parse(content);
        logger.info("接收处理队列A当中的JSONObject消息： " + content);
       // JSONObject jsonObject = JSONObject.parseObject(content);
       /* JSONObject encrypt = (JSONObject) jsonObject.get("encrypt");
        if (encrypt != null) {
            String status =(String) encrypt.get("status");
            switch (status) {
        case "上传回单":
            Map<String, Object> params = new HashMap<>(encrypt);
            params.put("receiptPic", params.get("imageObj"));
            params.put("waybillNo", params.get("waybillNumber"));
            break;

        default:

    }



} else {
        }
        */
        //logger.error("dsfsdfsdfsdfsdfs");
        }

@RabbitHandler
    public void process(JSONObject content) {
        logger.info("接收处理队列A当中的String消息： " + content);
        //logger.error("dsfsdfsdfsdfsdfs");
    }

}
