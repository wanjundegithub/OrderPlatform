package com.company.config;

import com.company.model.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;


@Component
public class KafkaSender {

    private static  final Logger logger= LoggerFactory.getLogger(KafkaSender.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    //构造器方式注入  kafkaTemplate
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private Gson gson = new GsonBuilder().create();

    public void send(String msg) {
        Message message = new Message();

        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        logger.info("【++++++++++++++++++ message ：{}】", gson.toJson(message));
        //对 topic =  test 的发送消息  ,使用回调，防止生产者丢失消息
        ListenableFuture<SendResult<String, String>> resultListenableFuture=kafkaTemplate.send("test",gson.toJson(message));
        resultListenableFuture.addCallback(result->logger.info("生产者成功发送消息到topic:{} partition:{}的消息",
               result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
               ex->logger.info(ex.getMessage()));

    }

}
