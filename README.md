# swapi-assignment

#Swapi -data-lift service: 
	Data Lift service takes the input  the SWAPI services request type and request name, based on that it retrieves the various components
	of the request type and request name.
#Tech Stack:
		Spring booot - 2.3.1
		java 8
		Maven 3.5.2
		
#Design (component level):
		1) Implemented swapi -data-lift service  using spring webflux to achieve reactive none blocking feature.
		
		2)StarWarsApiController - controller  which takes request type  & name as request parameters.
		
		3)SwapiService - retrieves the request type details and name details based on the input provided.
		
		  All the methods of swapi service are annotated with @Async annotation to execute in separate threads.
		  
			a)getItemDetails()- gets the urlfactory, check for data , if not available throws exception
			
			b)checkForData() - validates the type of request and makes getDataFromService(),
				Retrieves the data by calling different pagination params, if data not available in initial response
				(service calls done in iteration model until all pages are completed/ data is found).
				
			c)getDataFromService()- makes call to swapi url through webclient to achecieve asynchronous, non-blocking features.
			
		4)UrlFactory - factory class used to retrieve type of url factory based on request provided by client.
			ex: 1)return FilmsUrlService if request type is films
				2)return PeopleUrlService if request type is people.
			
			Below are the services which will be returned by url factory
			
			FilmsUrlService
			PeopleUrlService
			PlanetsUrlService
			SpeciesUrlService
			StarshipsUrlService
			VehicleUrlService
			
		5)#Security
		security is being achieved through Oauth2 for authorization.
		SecurityConfig - Authenticates the request based on role and credentials.
		SwapiOAuth2AuthServer - Oauth2 Authorization server.
		SwapiOAuth2ResServer - OAuth2 Resource server.
	
	

		
#Sample Request Response :
					#Request : http://localhost:8200/swapi/filmdetails?type=planets&name=Tatooine
					#Response:
					{
					    "count": 60,
					    "next": null,
					    "previous": "https://swapi.dev/api/planets/?page=5",
					    "results": [
					        {
					            "name": "Mirial",
					            "diameter": "unknown",
					            "rotation_period": "unknown",
					            "orbital_period": "unknown",
					            "gravity": "unknown",
					            "population": "unknown",
					            "climate": "unknown",
					            "terrain": "deserts",
					            "surface_water": "unknown",
					            "residents": [
					                "https://swapi.dev/api/people/64/",
					                "https://swapi.dev/api/people/65/"
					            ],
					            "films": [],
					            "url": "https://swapi.dev/api/planets/51/",
					            "created": "2014-12-20T16:44:46.318000Z",
					            "edited": "2014-12-20T20:58:18.508000Z"
					        }
					    ]
					}