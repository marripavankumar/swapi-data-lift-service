package com.swapi.data.service;

import org.springframework.core.ParameterizedTypeReference;

import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;

import reactor.core.publisher.Flux;

public interface SwapiService {
	
	<T> Flux<T> getItemDetails(String type ,String name) throws TypeNotFoundException,DataNotFoundException,Exception;
	<T> Flux<T>getDataFromService(String serviceUrl, 
			ParameterizedTypeReference<T> typeReference,String type, String name) throws Exception;
	<T> Flux<T> checkForData(String typeUrl, String type, String name, ParameterizedTypeReference<T> typeReference) throws DataNotFoundException,Exception;
}
