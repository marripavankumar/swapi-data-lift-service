package com.swapi.data.model;

import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;



@JsonComponent
public class Planets {// implements JsonBaseData{

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("next")
	private String next;

	@JsonProperty("previous")
	private String previous;

	@JsonProperty("results")
	private List<PlanetsResults> results;

	

	public Planets() {
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

	public List<PlanetsResults> getResults() {
		return results;
	}
	public void setResults(List<PlanetsResults> results) {
		this.results = results;
	}


//		public List<PlanetsResults> getResults() {
//		return results;
//	}
//	public void setResults(List<? extends JsonBaseResults> results) {
//		this.results = (List<PlanetsResults>) results;
//	}

}
