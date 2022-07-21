package com.swapi.data.model;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonComponent
public class RequestData {

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;
	
	
	public RequestData() {
		super();
	}
	public RequestData(String name, String type) {
		this.name = name;
		this.type= type;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "RequestData [name=" + name + ", type=" + type + "]";
	}
	
	
}
