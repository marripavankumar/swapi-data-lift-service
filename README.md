# swapi-assignment

**Swapi -data-lift service:** 
	
	Data Lift service takes the input  the SWAPI services request type and request name, based on that it retrieves the various components
	of the request type and request name.

**Tech Stack:**
		
	- Spring booot - 2.3.1
	- java 8
	- Maven 3.5.2
	- jenkins 2.355
	- junit 5
		
**Design (component level):**

1) Implemented swapi -data-lift service  using spring **webflux** to achieve reactive none blocking feature.
		
2) StarWarsApiController - controller  which takes request type  & name as request parameters.
		
3) SwapiService - retrieves the request type details and name details based on the input provided.
 All the methods of swapi service are annotated with **@Async** annotation to execute in separate threads.
		  
	a) getItemDetails()- gets the urlfactory, check for data , if not available throws exception
			
	b) checkForData() - validates the type of request and makes getDataFromService(),
	Retrieves the data by calling different pagination params, if data not available in initial response
	(service calls done in iteration model until all pages are completed/ data is found).
				
	c) getDataFromService()- makes call to swapi url through webclient to achecieve asynchronous, non-blocking features.
			
4) UrlFactory - factory class used to retrieve type of url factory based on request provided by client.
	ex: 
		1) return FilmsUrlService if request type is films
		2) return PeopleUrlService if request type is people.
			
Below are the services which will be returned by url factory
			
		-FilmsUrlService
		-PeopleUrlService
		-PlanetsUrlService
		-SpeciesUrlService
		-StarshipsUrlService
		-VehicleUrlService
			
**Security:**

		1) security is being achieved through Oauth2 for authorization.
		
		2) Implemented in memory security with user credentials and role USER
		
		-SecurityConfig - Authenticates the request based on role and credentials.
		-SwapiOAuth2AuthServer - Oauth2 Authorization server.
		-SwapiOAuth2ResServer - OAuth2 Resource server.
		
		**sample unauthorized response :**
		
		<UnauthorizedException>
		    <error>unauthorized</error>
		    <error_description>Full authentication is required to access this resource</error_description>
		</UnauthorizedException>
		
		
**steps to retrieve token:**
  
  **Authorization grant code: **
	http://localhost:8200/oauth/authorize?client_id=clientapp&response_type=code&scope=read_profile_info
	
  ** Access Token from Authorization Server: **
	
**Exception Handling:**

	-ApiError - Error message pojo to display custom messages based on http codes.
	-CustomRestExceptionHandler - controller Advice to handle exception messages bases on http response codes.
	-DataNotFoundException - Custom exception thrown when data not found.  
	-TypeNotFoundException - custom exception thrown when request type not found.

		
**Sample Request Response :**
**Request : **
		http://localhost:8200/swapi/filmdetails?type=planets&name=Tatooine

**Response:**
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
					
**CI/CD:** 

	1) jenkins is configured and created a **web hook** with git hub, intiates a build once code is committed.
	
	2) created pipeline script to generate artifacts after build.
	
	![jenkins](./images/jenkin.jpg)
	
	3) Build will be successful based on succesfful run of junit test cases.
	
**Open-API :**
	
	1) swapi-data-lift-service is configured with open-api specification.
	
	2) Details controllers, operations, request body, response codes can be viewed in the following link
		
		http://localhost:8200/swagger-ui/index.html#/
	
	
	
