package com.swapi.data.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.swapi.data.constants.SwapiConstants;
import com.swapi.data.model.RequestData;

 
@Service
public class KafkaProducerService 
{
    private static final Logger logger = 
            LoggerFactory.getLogger(KafkaProducerService.class);
     
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
 
    public void sendMessage(RequestData requestData) 
    {
        logger.info(String.format("Message sent -> %s", requestData));
        this.kafkaTemplate.send(SwapiConstants.TOPIC_NAME, requestData);
    }
}