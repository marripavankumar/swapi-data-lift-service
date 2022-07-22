package com.swapi.data.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.swapi.data.constants.SwapiConstants;
import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;
import com.swapi.data.model.RequestData;
import com.swapi.data.service.SwapiService;
 
@Service
public class KafkaConsumerService 
{
    private final Logger logger = 
            LoggerFactory.getLogger(KafkaConsumerService.class);
    
    @Autowired
    private  SwapiService swapiService;
 
    @KafkaListener(topics = SwapiConstants.TOPIC_NAME, 
            groupId = SwapiConstants.GROUP_ID, autoStartup = "${api.offline.enabled}")
    public void consume(String requestData) throws TypeNotFoundException, DataNotFoundException, Exception 
    {
        logger.info(String.format("Message recieved -> %s", requestData));
        String [] splitArray = requestData.split(":");
        swapiService.getItemDetails(splitArray[0], splitArray[1]);
    }
}