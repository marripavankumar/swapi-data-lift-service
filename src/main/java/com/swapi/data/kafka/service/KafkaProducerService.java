package com.swapi.data.kafka.service;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.swapi.data.constants.SwapiConstants;
import com.swapi.data.model.RequestData;

 
@Service
public class KafkaProducerService 
{
    private static final Logger logger = 
            LoggerFactory.getLogger(KafkaProducerService.class);
     
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
 
    public void sendMessage(String requestData) 
    {
        logger.info(String.format("Message sent -> %s", requestData));
//        this.kafkaTemplate.send(SwapiConstants.TOPIC_NAME, requestData);
        
        
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(SwapiConstants.TOPIC_NAME, requestData);

        //This will check producer result asynchronously to avoid thread blocking
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
          @Override
          public void onFailure(@NotNull Throwable throwable) {
            logger.error("Failed to send message", throwable);
          }

          @Override
          public void onSuccess(SendResult<String, Object> stringStringSendResult) {
            logger.info("Sent message successfully");
          }
        });
    }
}