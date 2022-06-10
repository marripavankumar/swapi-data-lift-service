package com.swapi.data.url.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.swapi.data.model.Starships;
import com.swapi.data.model.Vehicles;

@Component
public class StarshipsUrlService implements UrlService {
	
	@Value("${swapi.url.starships}")
	private String starshipsUrl;
	
	
	@Value("${swapi.url.starshipsType}")
	private String starshipsType;
	
	@Override
	public String getType() {
		return starshipsType ;
	}

	@Override
	public <T> ParameterizedTypeReference<T> getParameterizedType() {
		// TODO Auto-generated method stub
		return (ParameterizedTypeReference<T>) new ParameterizedTypeReference<Starships>() {};
	}

	@Override
	public String getTypeUrl() {
		// TODO Auto-generated method stub
		return starshipsUrl;
	}

}
