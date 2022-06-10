package com.swapi.data.model;

//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "name")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = PeopleResults.class),
//        @JsonSubTypes.Type(value = FilmsResults.class),
//        @JsonSubTypes.Type(value = StarshipsResults.class),
//        @JsonSubTypes.Type(value = SpeciesResults.class),
//        @JsonSubTypes.Type(value = PlanetsResults.class),
//        @JsonSubTypes.Type(value = VehiclesResults.class)})
public abstract class JsonBaseResults  {
	public abstract Object getName();
}
