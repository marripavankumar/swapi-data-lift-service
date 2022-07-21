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
	
	
	public static final String REQUEST_MAPPING_SWAPI=  "/swapi";
	public static final String  GET_MAPPING_FILM_DETAILS = "/filmdetails";
	public static final String  INTERNAL_SERVER_ERROR = "Data Not Foud | Request Type is not available";
	public static final String  TYPE_SERVICE_NOT_FOUND= "Service  not found";
	public static final String  OK= "Successfull";
	
	//HTTP STATUS CODE
	public static final String HTTP_STATUS_CODE_500 = "500";
	public static final String HTTP_STATUS_CODE_200 = "200";
	public static final String HTTP_STATUS_CODE_404 = "404";
	
	
	
	//SECURITY constants
	public static final String SECURITY_ROLE_USER="USER";
	public static final String CLIENT_APP= "clientapp";
	public static final String GRANT_TYPE_PASSWORD= "password";
	public static final String GRANT_TYPE_AUTHORIZATION = "authorization_code";
	public static final String GRANT_TYPE_REFRESH_TOKEN= "refresh_token";
	public static final String READ_ONLY_CLIENT = "READ_ONLY_CLIENT";
	public static final String READ_PROFILE_INFO = "read_profile_info";
	public static final String OAUTH2_RESOURCE = "oauth2-resource";
	public static final String REDIRECT_URL = "http://localhost:8200/login";
	
	public static final String UNAUTHORIZED = "Unauthorized";
	public static final String AUTHORIZED= "Authorization";
	public static final String BEARER = "Bearer ";
	public static final String AUTHENTICATE= "/authenticate";
	public static final String UNABLE_TO_GET_JWT_TOKEN ="Unable to get JWT Token";
	public static final String JWT_TOKEN_EXPIRED= "JWT Token has expired";
	public static final String BEARER_NOT_FOUND= "JWT Token does not begin with Bearer String";
	
	public static final String SWAGGER_AUTHORIZED = "/swagger-ui/*";
	public static final String SWAGGER_API_DOCS = "/api-docs";
	
	
	//Kafka Constants
	public static final String TOPIC_NAME = "swapi-offline-data-topic";
	public static final String GROUP_ID = "swapi-group";
}	
