package com.swapi.data.service;

import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;

import reactor.core.publisher.Flux;

public interface SwapiService {
	
	<T> Flux<T> getItemDetails(String type ,String name) throws TypeNotFoundException,DataNotFoundException,Exception;
}
