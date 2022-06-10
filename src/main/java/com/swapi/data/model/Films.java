package com.swapi.data.model;

import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonComponent
public class Films {//implements JsonBaseData {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("next")
	private String next;

	@JsonProperty("previous")
	private String previous;


	@JsonProperty("results")
	private List<FilmsResults> results;

	

	public Films() {
		super();
	}
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
	public List<FilmsResults> getResults() {
		return results;
	}
	public void setResults(List<FilmsResults> results) {
		this.results = results;
	}

	
//	public List<FilmsResults> getResults() { return results; }
//
//	@Override 
//	public void setResults(List<? extends JsonBaseResults> results) {
//		this.results = (List<FilmsResults>)results; 
//	}
//	 



}
