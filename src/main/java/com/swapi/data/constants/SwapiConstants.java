package com.swapi.data.constants;

public class SwapiConstants {
	
	public static final String REQ_PARAM_TYPE_EXPECTED = "Request param 'type' is madatory, cannot be empty or null";
	public static final String REQ_PARAM_NAME_EXPECTED = "Request param 'name' is madatory, cannot be empty or null";
	public static final String DATA_NOT_FOUND = "Data Not Found";
	
	public static final String TYPE_NOT_FOUND_EXCEPTION = "Requested Url Type is not found." ;
//	public static final String DATA_FOUND_EXCEPTION = "Requested Data Not Found" ;
	
	public static final String MEDIA_TYPE_APP_VND = "application/vnd.spring-boot.actuator.v2+json";
	
	public static final String TYPE_PLANETS = "planets";
	public static final String TYPE_PEOPLE = "people";
	public static final String TYPE_FILMS= "films";
	public static final String TYPE_VEHICLES= "vehicles";
	public static final String TYPE_SPICIES= "species";
	public static final String TYPE_STAR_SHIPS= "starships";
	
	
	public static final String REQUEST_MAPPING=  "/swapi";
	public static final String  GET_MAPPING_FILM_DETAILS = "/filmdetails";
	public static final String  INTERNAL_SERVER_ERROR = "Data Not Foud | Request Type is not available";
	public static final String  TYPE_SERVICE_NOT_FOUND= "Service  not found";
	public static final String  OK= "Successfull";
	
	//HTTP STATUS CODE
	public static final String HTTP_STATUS_CODE_500 = "500";
	public static final String HTTP_STATUS_CODE_200 = "200";
	public static final String HTTP_STATUS_CODE_404 = "404";
	
	public static final String SECURITY_ROLE_USER="USER";
	
	
}
