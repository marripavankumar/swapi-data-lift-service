package com.swapi.data.exception;

@SuppressWarnings("serial")
public class DataNotFoundException  extends Exception{

	public DataNotFoundException(String message) {
		super(message);
	}
}
