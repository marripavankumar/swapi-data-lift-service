package com.swapi.data.kafka.producer;


import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.swapi.data.model.RequestData;

@Component
public final class Producer {

  private static final Logger logger = LoggerFactory.getLogger(Producer.class);

  @Autowired
  private final KafkaTemplate<String, Object> kafkaTemplate;

  public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(RequestData requestData) {
    String topicName = "rest-spring-boot-integration";
    ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, requestData);

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
