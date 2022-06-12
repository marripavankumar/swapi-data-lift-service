package com.swapi.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.swapi.data.constants.SwapiConstants;
import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;
import com.swapi.data.model.Films;
import com.swapi.data.model.FilmsResults;
import com.swapi.data.model.People;
import com.swapi.data.model.PeopleResults;
import com.swapi.data.model.Planets;
import com.swapi.data.model.PlanetsResults;
import com.swapi.data.model.Species;
import com.swapi.data.model.SpeciesResults;
import com.swapi.data.model.Starships;
import com.swapi.data.model.StarshipsResults;
import com.swapi.data.model.Vehicles;
import com.swapi.data.model.VehiclesResults;
import com.swapi.data.url.service.UrlFactory;
import com.swapi.data.url.service.UrlService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class SwapiServiceImpl<T> implements SwapiService {

	@Value("${swapi.url}")
	String baseUrl;

	private static Logger logger = LoggerFactory.getLogger(SwapiServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public <T> Flux<T> getItemDetails(String type, String name) throws TypeNotFoundException,DataNotFoundException,Exception {
		UrlService service = UrlFactory.getService(type.toLowerCase());
		
		if(null == service ) {
			throw new TypeNotFoundException(SwapiConstants.TYPE_FILMS);
		}
		
		Flux<T> data =  checkForData(service.getTypeUrl(),service.getType(), name,service.getParameterizedType());
	
		if(null == data) {
			throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
		}
		
		return data;
	}

	@SuppressWarnings("hiding")
	@Async
	public <T> Flux<T>getDataFromService(String serviceUrl, 
			ParameterizedTypeReference<T> typeReference) throws Exception {

		Flux<T> responseDataFlux = null;
			responseDataFlux = WebClient.create()
					.get()
					.uri(serviceUrl)
					.retrieve()
					.onStatus(HttpStatus::is4xxClientError, clientResponse ->
							Mono.error(new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND))
					)
					.onStatus(HttpStatus::is5xxServerError, clientResponse ->
						Mono.error(new Exception())
					)
					.bodyToFlux(typeReference);
			//			responseDataFlux.subscribe(response -> response.getClass());
		
		return responseDataFlux;
	}
	
	@Async
	public <T> Flux<T> checkForData(String typeUrl, String type, String name, ParameterizedTypeReference<T> typeReference) throws DataNotFoundException,Exception{
		
		boolean performSearch = true;
		Flux<T> response = null;
		while(performSearch) {
			Flux<T> data = getDataFromService(typeUrl,typeReference);
			if(type.equalsIgnoreCase(SwapiConstants.TYPE_PEOPLE)) {
				People people = (People)data.blockFirst();
				AtomicReference<PeopleResults> peopleResult = new AtomicReference<>();
				people.getResults().parallelStream().forEach(
						result ->{
							if( result.getName().equals(name)) {
								peopleResult.set(result);
							}
						});
				if(null == peopleResult.get()) {
					if(null!= people.getNext()) {
						typeUrl = people.getNext()	;
						continue;
					}else {
						performSearch = false;
						throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
					}
				}else {
					List<PeopleResults> results = new ArrayList<>();
					results.add(peopleResult.get());
					people.setResults(results);
					response =  (Flux<T>) Flux.just(people);
					performSearch = false;
				}
			}
			else if(type.equalsIgnoreCase(SwapiConstants.TYPE_PLANETS)) {
				Planets planets = (Planets)data.blockFirst();
				AtomicReference<PlanetsResults> planetResult = new AtomicReference<>();
				planets.getResults().parallelStream().forEach(
						result ->{
							if( result.getName().equals(name)) {
								planetResult.set(result);
							}
						});
				if(null == planetResult.get()) {
					if(null!= planets.getNext()) {
						typeUrl = planets.getNext()	;
						continue;
					}else {
						performSearch = false;
						throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
					}
				}else {
					List<PlanetsResults> results = new ArrayList<>();
					results.add(planetResult.get());
					planets.setResults(results);
					response =  (Flux<T>) Flux.just(planets);
					performSearch = false;
				}
			}
			
			else if(type.equalsIgnoreCase(SwapiConstants.TYPE_FILMS)) {
				Films films = (Films)data.blockFirst();
				AtomicReference<FilmsResults> filmsResult = new AtomicReference<>();
				films.getResults().parallelStream().forEach(
						result ->{
							if( result.getName().equals(name)) {
								filmsResult.set(result);
							}
						});
				if(null == filmsResult.get()) {
					if(null!= films.getNext()) {
						typeUrl = films.getNext()	;
						continue;
					}else {
						performSearch = false;
						throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
					}
				}else {
					List<FilmsResults> results = new ArrayList<>();
					results.add(filmsResult.get());
					films.setResults(results);
					response =  (Flux<T>) Flux.just(films);
					performSearch = false;
				}
			}
			else if(type.equalsIgnoreCase(SwapiConstants.TYPE_VEHICLES)) {
				Vehicles vehicles = (Vehicles)data.blockFirst();
				AtomicReference<VehiclesResults> vehicleResults = new AtomicReference<>();
				vehicles.getResults().parallelStream().forEach(
						result ->{
							if( result.getName().equals(name)) {
								vehicleResults.set(result);
							}
						});
				if(null == vehicleResults.get()) {
					if(null!= vehicles.getNext()) {
						typeUrl = vehicles.getNext()	;
						continue;
					}else {
						performSearch = false;
						throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
					}
				}else {
					List<VehiclesResults> results = new ArrayList<>();
					results.add(vehicleResults.get());
					vehicles.setResults(results);
					response =  (Flux<T>) Flux.just(vehicles);
					performSearch = false;
				}
			}
			
			else if(type.equalsIgnoreCase(SwapiConstants.TYPE_SPICIES)) {
				Species species = (Species)data.blockFirst();
				AtomicReference<SpeciesResults> speciesResults = new AtomicReference<>();
				species.getResults().parallelStream().forEach(
						result ->{
							if( result.getName().equals(name)) {
								speciesResults.set(result);
							}
						});
				if(null == speciesResults.get()) {
					if(null!= species.getNext()) {
						typeUrl = species.getNext()	;
						continue;
					}else {
						performSearch = false;
						throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
					}
				}else {
					List<SpeciesResults> results = new ArrayList<>();
					results.add(speciesResults.get());
					species.setResults(results);
					response =  (Flux<T>) Flux.just(species);
					performSearch = false;
				}
			}
			else if(type.equalsIgnoreCase(SwapiConstants.TYPE_STAR_SHIPS)) {
				Starships starships = (Starships)data.blockFirst();
				AtomicReference<StarshipsResults> starshipsResults= new AtomicReference<>();
				starships.getResults().parallelStream().forEach(
						result ->{
							if( result.getName().equals(name)) {
								starshipsResults.set(result);
							}
						});
				if(null == starshipsResults.get()) {
					if(null!= starships.getNext()) {
						typeUrl = starships.getNext()	;
						continue;
					}else {
						performSearch = false;
						throw new DataNotFoundException(SwapiConstants.DATA_NOT_FOUND);
					}
				}else {
					List<StarshipsResults> results = new ArrayList<>();
					results.add(starshipsResults.get());
					starships.setResults(results);
					response =  (Flux<T>) Flux.just(starships);
					performSearch = false;
				}
			}
		}
		
		
		return response;
	}

	
//TODO : Needto check on generic soluion instead of typecasting to each POJO 
//	@Async
//	public <T> Flux<T> checkForData(String typeUrl, String type, String name, ParameterizedTypeReference<T> typeReference) throws Exception{
//
//		boolean performSearch = true;
//		Flux<T> response = null;
//		while(performSearch) {
//			Flux<T> data = getDataFromService(typeUrl,typeReference);
//			JsonBaseData jsonBaseData = null;
//			AtomicReference<JsonBaseResults> objectResult = new AtomicReference<>();
//			jsonBaseData = SwapiUtility.getJsonBaseDataByType(type, data, jsonBaseData);
//			jsonBaseData.getResults().parallelStream().forEach(
//					result ->{
////						result = SwapiUtility.getJsonBaseResultsType(type, result);
//						if( ((JsonBaseResults) result).getName().equals(name)) {
//							objectResult.set((JsonBaseResults) result);
//						}
//					});
//			if(null == objectResult.get()) {
//				if(null!= jsonBaseData.getNext()) {
//					typeUrl = jsonBaseData.getNext();
//					continue;
//				}else {
//					response =  (Flux<T>) Flux.just(SwapiConstants.DATA_NOT_FOUND);
//					performSearch = false;
//				}
//			}else {
//				List<JsonBaseResults> results = new ArrayList<>();
//				results.add(objectResult.get());
//				jsonBaseData.setResults(results);
//				response =  (Flux<T>) Flux.just(jsonBaseData);
//				performSearch = false;
//			}
//
//		}
//		return response;
//	}
	
}
