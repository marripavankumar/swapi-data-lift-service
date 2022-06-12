package com.swapi.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapi.data.constants.SwapiConstants;
import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;
import com.swapi.data.model.DataNotFound;
import com.swapi.data.model.Films;
import com.swapi.data.model.People;
import com.swapi.data.model.Planets;
import com.swapi.data.model.Species;
import com.swapi.data.model.Starships;
import com.swapi.data.model.TypeNotFound;
import com.swapi.data.model.Vehicles;
import com.swapi.data.service.SwapiService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = SwapiConstants.REQUEST_MAPPING)
public class StarWarsApiController {

	@Autowired
	private  SwapiService swapiService;




	@SuppressWarnings("static-access")
	@ApiResponses(value = {
			@ApiResponse(responseCode = SwapiConstants.HTTP_STATUS_CODE_500, description = SwapiConstants.INTERNAL_SERVER_ERROR),
			@ApiResponse(responseCode = SwapiConstants.HTTP_STATUS_CODE_404, description = SwapiConstants.TYPE_SERVICE_NOT_FOUND),
			@ApiResponse(responseCode = SwapiConstants.HTTP_STATUS_CODE_200, description = SwapiConstants.OK ,
				content = {@Content(schema = @Schema(oneOf = {People.class,Vehicles.class,Species.class,Starships.class,Planets.class,Films.class}))}
			) })
	
	@GetMapping(value = SwapiConstants.GET_MAPPING_FILM_DETAILS, produces = {MediaType.APPLICATION_JSON_VALUE})
	public  <T> Mono<T> getSwapiDetails(@RequestParam(required = true) String  type, 
			@RequestParam(required = true) String name )  {
		Flux<T> response = null;
		try {
			response = swapiService.getItemDetails(type, name);
		} catch (DataNotFoundException  | NullPointerException | TypeNotFoundException e) {
			response.just(new DataNotFound());
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return response.single();
	}
}