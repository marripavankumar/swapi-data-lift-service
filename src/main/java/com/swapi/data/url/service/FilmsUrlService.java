package com.swapi.data.url.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import com.swapi.data.model.Films;

@Component
public class FilmsUrlService implements UrlService {
	
	@Value("${swapi.url.films}")
	private String filmUrl;
	
	@Value("${swapi.url.filmsType}")
	private String filmType;
	
	@Override
	public String getType() {
		return filmType ;
	}
	@Override
	public String getTypeUrl() {
		return filmUrl;
	}

	@Override
	public <T> ParameterizedTypeReference<T> getParameterizedType() {
		return (ParameterizedTypeReference<T>) new ParameterizedTypeReference<Films>() {};
	}

	
}
