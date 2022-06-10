package com.swapi.data.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Starships{// implements JsonBaseData {


	@JsonProperty("count")
	private Integer count;
	
	@JsonProperty("next")
	private String next;
	
	@JsonProperty("previous")
	private String previous;
	
	@JsonProperty("results")
	private List<StarshipsResults> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<StarshipsResults> getResults() {
		return results;
	}

	public void setResults(List<StarshipsResults> results) {
		this.results = results;
	}

//	public List<StarshipsResults> getResults() {
//		return results;
//	}
//
//	public void setResults(List<? extends JsonBaseResults> results) {
//		this.results = (List<StarshipsResults>) results;
//	}
//	
	

}
