package com.swapi.data.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swapi.data.exception.DataNotFoundException;
import com.swapi.data.exception.TypeNotFoundException;
import com.swapi.data.model.Planets;
import com.swapi.data.url.service.UrlFactory;
import com.swapi.data.url.service.UrlService;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class SwapiServiceImplTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Autowired 
	SwapiService swapiService;
	
	@Test
	void testGetItemDetails() throws TypeNotFoundException, DataNotFoundException, Exception {
		
		Flux<Planets> planetData = swapiService.getItemDetails("planets", "Tatooine");
		
		assertNotNull(planetData);
		Planets planets = planetData.blockFirst();
		assertEquals(planets.getCount(), 60);
		assertNull(planets.getPrevious());
		assertNotNull(planets.getNext());
		assertTrue(planets.getResults().size() > 0 );
		assertEquals(planets.getResults().get(0).getName(), "Tatooine");
	}
	
	@Test
	void testGetItemDetailsDataNotFoundException() {
		assertThrows(DataNotFoundException.class, ()->{Flux<Planets> planetData = swapiService.getItemDetails("planets", "Mirial2");});
		
	}
	
	@Test
	void testGetItemDetailsWithTypeNotFound() {
		assertThrows(TypeNotFoundException.class, ()->{Flux<Planets> planetData = swapiService.getItemDetails("planets1", "Tatooine");});
		
	}

	@Test
	void testGetDataFromService() throws Exception {
		
		String type = "planets";
		String serviceUrl = "https://swapi.dev/api/planets/?page=2";
		
		UrlService service = UrlFactory.getService(type.toLowerCase());
		
		Flux<Planets> planetData = swapiService.getDataFromService(serviceUrl, service.getParameterizedType());
		
		Planets planets = planetData.blockFirst();
		assertEquals(planets.getCount(), 60);
		assertNotNull(planets.getPrevious());
		assertNotNull(planets.getNext());
		assertTrue(planets.getResults().size() > 0 );
		assertEquals(planets.getResults().get(0).getName(), "Geonosis");
		
	}
	@Test
	void testGetDataFromServiceException() {
		String type = "planets1";
		UrlService service = UrlFactory.getService(type.toLowerCase());
		assertThrows(Exception.class, ()->{Flux<Planets> planetData = swapiService.getDataFromService(service.getTypeUrl(), service.getParameterizedType());});
	}
	
	
	@Test
	void testCheckForDataThrowsException() {
		String type = "planets1";
		UrlService service = UrlFactory.getService(type.toLowerCase());
		assertThrows(Exception.class, ()->{Flux<Planets> planetData = swapiService.checkForData(service.getTypeUrl(), type, "Tatooine", service.getParameterizedType());});
	}

	@Test
	void testCheckForData() throws DataNotFoundException, Exception {
		String type = "planets";
		UrlService service = UrlFactory.getService(type.toLowerCase());
		Flux<Planets> planetData = swapiService.checkForData(service.getTypeUrl(), type, "Tatooine", service.getParameterizedType());
	}
}
