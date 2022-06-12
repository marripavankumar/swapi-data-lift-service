package com.swapi.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;
import com.swapi.data.model.DataNotFound;
import com.swapi.data.model.TypeNotFound;
import com.swapi.data.service.SwapiService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/swapi")
public class StarWarsApiController {

	@Autowired
	private  SwapiService swapiService;

	
	@GetMapping(value = "/filmdetails", produces = {MediaType.APPLICATION_JSON_VALUE})
	public  <T> Mono<T> getSwapiDetails(@RequestParam(required = true) String  type, 
			@RequestParam(required = true) String name )  {
		Flux<T> response = null;
		try {
			response = swapiService.getItemDetails(type, name);
		} catch (DataNotFoundException  | NullPointerException e) {
			response.just(new DataNotFound());
		}
		catch (TypeNotFoundException e) {
			response.just(new TypeNotFound());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response.single();
	}
}