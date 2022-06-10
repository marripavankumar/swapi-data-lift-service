package com.swapi.data.url.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.swapi.data.model.Planets;

@Component
public class PlanetsUrlService implements UrlService {
	
	@Value("${swapi.url.planets}")
	private String planetUrl;
	
	
	@Value("${swapi.url.planetsType}")
	private String planetsType;
	
	
	@Override
	public String getType() {
		return planetsType ;
	}
	
	

	@Override
	public <T> ParameterizedTypeReference<T> getParameterizedType() {
		return (ParameterizedTypeReference<T>) new ParameterizedTypeReference<Planets>() {};
	}



	@Override
	public String getTypeUrl() {
		// TODO Auto-generated method stub
		return planetUrl;
	}

}
