package com.swapi.data.model;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonComponent
public class FilmsResults {//extends JsonBaseResults{

	@JsonProperty("title")
	private String name;
	
	@JsonProperty("episode_id")
	private Integer episode_id;
	
	@JsonProperty("opening_crawl")
	private String opening_crawl;
	
	@JsonProperty("director")
	private String director;
	
	@JsonProperty("producer")
	private String producer;
	
	@JsonProperty("release_date")
	private Date release_date;
	
	@JsonProperty("species")
    private List<String> species;
	
	@JsonProperty("starships")
    private List<String> starships;
	
	@JsonProperty("vehicles")
    private List<String> vehicles;
	
	@JsonProperty("characters")
    private List<String> characters;
	
	@JsonProperty("planets")
    private List<String> planets;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("edited")
	private String edited;
	
	

	public FilmsResults() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(Integer episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public List<String> getStarships() {
		return starships;
	}

	public void setStarships(List<String> starships) {
		this.starships = starships;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

	public List<String> getPlanets() {
		return planets;
	}

	public void setPlanets(List<String> planets) {
		this.planets = planets;
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
