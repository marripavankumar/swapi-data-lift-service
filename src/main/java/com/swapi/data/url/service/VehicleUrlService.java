package com.swapi.data.url.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.swapi.data.model.Vehicles;

@Component
public class VehicleUrlService implements UrlService {
	
	@Value("${swapi.url.vehicles}")
	private String vehiclesUrl;
	
	@Value("${swapi.url.vehiclesType}")
	private String vehiclesType;
	
	@Override
	public String getType() {
		return vehiclesType ;
	}

	@Override
	public <T> ParameterizedTypeReference<T> getParameterizedType() {
		// TODO Auto-generated method stub
		return (ParameterizedTypeReference<T>) new ParameterizedTypeReference<Vehicles>() {};
	}

	@Override
	public String getTypeUrl() {
		// TODO Auto-generated method stub
		return vehiclesUrl;
	}

}
