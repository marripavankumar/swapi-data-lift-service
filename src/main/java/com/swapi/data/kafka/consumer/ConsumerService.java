package com.swapi.data.kafka.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.swapi.data.model.RequestData;
import com.swapi.data.service.SwapiService;

@Service
public final class ConsumerService {

  private final RequestData requestData;
  
  @Autowired
  SwapiService swapiService;

  public ConsumerService(RequestData requestData) {
    this.requestData = requestData;
  }

  @KafkaListener(topics = "rest-spring-boot-integration", containerFactory = "kafkaListenerContainerFactory")
  public void consume(String requestUrl) {

  
  }
}
