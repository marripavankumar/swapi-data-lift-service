package com.swapi.data.model;

import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonComponent
public class  PlanetsResults { //extends JsonBaseResults{

	@JsonProperty("name")
	private String name;

	@JsonProperty("diameter")
	private String diameter;

	@JsonProperty("rotation_period")
	private String rotation_period;

	@JsonProperty("orbital_period")
	private String orbital_period;

	@JsonProperty("gravity")
	private String gravity;

	@JsonProperty("population")
	private String population;

	@JsonProperty("climate")
	private String climate;

	@JsonProperty("terrain")
	private String terrain;

	@JsonProperty("surface_water")
	private String surface_water;

	@JsonProperty("residents")
	private List<String> residents;

	@JsonProperty("films")
	private List<String> films;

	@JsonProperty("url")
	private String url;

	@JsonProperty("created")
	private String created;

	@JsonProperty("edited")
	private String edited;

	
	public PlanetsResults() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getRotation_period() {
		return rotation_period;
	}
	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}
	public String getOrbital_period() {
		return orbital_period;
	}
	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getSurface_water() {
		return surface_water;
	}
	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}
	public List<String> getResidents() {
		return residents;
	}
	public void setResidents(List<String> residents) {
		this.residents = residents;
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