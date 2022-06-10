package com.swapi.data.url.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.swapi.data.model.Species;

@Component
public class SpeciesUrlService implements UrlService {
	
	@Value("${swapi.url.species}")
	private String speciesUrl;
	
	@Value("${swapi.url.speciesType}")
	private String speciesType;
	
	@Override
	public String getType() {
		return speciesType ;
	}

	@Override
	public <T> ParameterizedTypeReference<T> getParameterizedType() {
		// TODO Auto-generated method stub
		return (ParameterizedTypeReference<T>) new ParameterizedTypeReference<Species>() {};
	}

	@Override
	public String getTypeUrl() {
		// TODO Auto-generated method stub
		return speciesUrl;
	}

}
