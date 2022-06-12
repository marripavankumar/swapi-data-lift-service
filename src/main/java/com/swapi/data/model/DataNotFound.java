package com.swapi.data.model;

import java.time.LocalDateTime;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swapi.data.constants.SwapiConstants;

@JsonComponent
public class DataNotFound {
		
	
	@JsonProperty("message")
	private String message;

	@JsonProperty("created_time")
	private LocalDateTime created_time;

	public DataNotFound() {
		this.message = SwapiConstants.DATA_NOT_FOUND;
		created_time = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreated_time() {
		return created_time;
	}

	public void setCreated_time(LocalDateTime created_time) {
		this.created_time = created_time;
	}

	@Override
	public String toString() {
		return "DataNotFound {message:" + message + ", created_time:" + created_time + "}";
	}
	
	
}
