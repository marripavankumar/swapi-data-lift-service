package com.swapi.data.util;

import com.swapi.data.constants.SwapiConstants;
import com.swapi.data.model.Films;
import com.swapi.data.model.JsonBaseData;
import com.swapi.data.model.People;
import com.swapi.data.model.Planets;
import com.swapi.data.model.Species;
import com.swapi.data.model.Starships;

import reactor.core.publisher.Flux;

public class SwapiUtility {

//	public static <T> JsonBaseData getJsonBaseDataByType(String type, Flux<T> data, JsonBaseData jsonBaseData) {
//	
//		if(type.equalsIgnoreCase(SwapiConstants.TYPE_PEOPLE)) {
//			People people= (People)data.blockFirst();
//			return people;
//			
//		}
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_FILMS)) {
//			Films films  = (Films)data.blockFirst();
//			return films;
//		}
//
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_PLANETS)) {
//			Planets planets = (Planets)data.blockFirst();
//			return planets;
//			
//		}
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_SPICIES)) {
//			Species species = (Species)data.blockFirst();
//			return species;
//		}
//
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_STAR_SHIPS)) {
//			Starships starships = (Starships)data.blockFirst();
//			return starships;
//		}
//		return null;
//	}

//	public static  List<JsonBaseResults> getJsonBaseResultsType(String type ,List<JsonBaseResults> jsonBaseResults) {
//		ObjectMapper mapper = new ObjectMapper();
//		if(type.equalsIgnoreCase(SwapiConstants.TYPE_PEOPLE)) {
//			List<PeopleResults> myObjects = Arrays.asList(mapper.readValue(jsonBaseResults, PeopleResults[].class));
//			jsonBaseResults =(List<PeopleResults>)jsonBaseResults;
//		}
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_FILMS)) {
//			result =(FilmsResults)result;
//		}
//
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_PLANETS)) {
//			result =(PlanetsResults)result;
//		}
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_SPICIES)) {
//			result =(SpeciesResults)result;
//		}
//
//		else if(type.equalsIgnoreCase(SwapiConstants.TYPE_STAR_SHIPS)) {
//			result =(StarshipsResults)result;
//		}
//		return result;
//	}
}
