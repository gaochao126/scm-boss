package com.superb.controller.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @RequestMapping("kafka/send")
    public String send(String msg){
        kafkaTemplate.send("demo", msg); //使用kafka模板发送信息
        return "success";
    }
}
