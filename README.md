# swapi-assignment
	#Design :
		Implemented ***swapi -data-lift service***  using spring ***webflux*** to get the reactive  none blocking feature.
	
	#Tech Stack:
		Spring booot - 2.3.1
		java 8
		
	#Components-Funtionality:
		#Swapi -data-lift service: 
			Data Lift service takes the input  the SWAPI services request type and request name, based on that it retrieves the various components
		of the request type and request name.
		
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