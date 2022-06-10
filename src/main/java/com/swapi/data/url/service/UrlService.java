package com.swapi.data.url.service;

import org.springframework.core.ParameterizedTypeReference;

public interface UrlService {
	String getType();
	String getTypeUrl();
	<T> ParameterizedTypeReference<T> getParameterizedType();
}
