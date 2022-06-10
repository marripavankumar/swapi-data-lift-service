package com.swapi.data.url.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.swapi.data.model.People;

@Component
public class PeopleUrlService implements UrlService {
	
	@Value("${swapi.url.people}")
	private String peopleUrl;
	
	@Value("${swapi.url.peopleType}")
	private String peopleType;
	
	@Override
	public String getType() {
		return peopleType;
	}
	
	@Override
	public <T> ParameterizedTypeReference<T> getParameterizedType() {
		return (ParameterizedTypeReference<T>) new ParameterizedTypeReference<People>() {};
	}

	@Override
	public String getTypeUrl() {
		return peopleUrl;
	}

}
