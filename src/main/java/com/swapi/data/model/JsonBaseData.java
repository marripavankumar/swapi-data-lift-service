package com.swapi.data.model;

import java.util.List;

public interface JsonBaseData {
	
	<T> List<T> getResults();
	String getNext();
	void setResults(List<? extends JsonBaseResults> results);
}
