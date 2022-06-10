package com.swapi.data.model;

import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonComponent
public class SpeciesResults{// extends JsonBaseResults{

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("classification")
	private String classification;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("average_height")
	private String average_height;
	
	@JsonProperty("average_lifespan")
	private String average_lifespan;
	
	@JsonProperty("eye_colors")
	private String eye_colors;
	
	@JsonProperty("hair_colors")
	private String hair_colors;
	
	@JsonProperty("skin_colors")
	private String skin_colors;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("homeworld")
	private String homeworld;
	
	@JsonProperty("people")
	private List<String> people;
	
	@JsonProperty("films")
	private List<String> films;
	
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("edited")
	private String edited;
	
	

	public SpeciesResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAverage_height() {
		return average_height;
	}

	public void setAverage_height(String average_height) {
		this.average_height = average_height;
	}

	public String getAverage_lifespan() {
		return average_lifespan;
	}

	public void setAverage_lifespan(String average_lifespan) {
		this.average_lifespan = average_lifespan;
	}

	public String getEye_colors() {
		return eye_colors;
	}

	public void setEye_colors(String eye_colors) {
		this.eye_colors = eye_colors;
	}

	public String getHair_colors() {
		return hair_colors;
	}

	public void setHair_colors(String hair_colors) {
		this.hair_colors = hair_colors;
	}

	public String getSkin_colors() {
		return skin_colors;
	}

	public void setSkin_colors(String skin_colors) {
		this.skin_colors = skin_colors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public List<String> getPeople() {
		return people;
	}

	public void setPeople(List<String> people) {
		this.people = people;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}
	
	
}
