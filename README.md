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

		1) security is being achieved through JWT for Authentication.
		
		2) Implemented in memory security with user credentials
		
		-JwtAuthenticationEntryPoint.java - Entry point for JWT Authentication.
		-JwtRequestFilter.java - Filtr to retrieve Bearer token associated with header.
		-JwtTokenUtil.java - Utility class to generate and validate token.
		-WebSecurityConfig.java - condition on Authentication requests.
	
		**sample unauthorized response :**
		
		{
		    "timestamp": 1657996758354,
		    "status": 401,
		    "error": "Unauthorized",
		    "message": "",
		    "path": "/swapi/filmdetails"
		}
		
		
**steps to retrieve token:**
  
**Authentication : **
		http://localhost:8200/authenticate
		request body:
			{
			    "username": "xxx",
			    "password": "xxx"
			}
** Access Token from Authorization Server: **
  	{
    "token": "xxxx"
	}	
	
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
					
					
**Kafka Configuration**

	zookeeper start -- 
				zookeeper-server-start.bat D:\sofwares\kafka\config\zookeeper.properties
	kafka-start -- 
				kafka-server-start.bat D:\sofwares\kafka\config\server.properties
				
**creation topic: kafka :syntax Examples -- command prompt**
	
	kafka-topics -zookeeper localhost:2181 -topic <topic_name> -create  
	kafka-topics  --zookeeper localhost:2181 --create --topic swapi-offline-data-topic--partitions 2 --replication-factor 2
	kafka-topics  --bootstrap-server localhost:2181 --create --topic swapi-offline-data-topic --partitions 2 --replication-factor 2
	kafka-console-consumer -bootstrap-server localhost:9092 -topic -group swapi-group
	
**Kafka Producer and Consumer:**
	
	kafka-console-producer.bat -broker-list localhost:9092 -topic swapi-offline-data-topic
	kafka-console-consumer.bat -bootstrap-server localhost:9092 -topic swapi-offline-data-topic
	
**Kafka Producer and Consumer services**
	
	Config.java -- kafka consumer factory configuration	
	KafkaConsumerService.java-- Kafka consumer servces which consumes messages when api.offline.enbled =true and calls SwapiService.getItems() once starwar api is up.
	KafkaProducerService.java --publish RequestData  to kafka topic during starwaar api is on offline mode.

	
**CI/CD:** 

	1) jenkins is configured and created a **web hook** with git hub, intiates a build once code is committed.
	
	2) created pipeline script to generate artifacts after build.
	
	![jenkins](./images/jenkin.jpg)
	
	3) Build will be successful based on succesfful run of junit test cases.
	
**Open-API :**
	
	1) swapi-data-lift-service is configured with open-api specification.
	
	2) Details controllers, operations, request body, response codes can be viewed in the following link
		
		http://localhost:8200/swagger-ui/index.html#/
	
	
**Code-Coverage:**	
	
	Running : start batch file in belowpath.
	sonarqube-6.7.7\bin\windows-x86-64\StartNTService.bat
  	sonarQubeportal : http://localhost:9000 
  	
  	