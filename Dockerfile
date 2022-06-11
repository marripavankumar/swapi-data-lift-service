FROM openjdk:8-jdk-alpine
MAINTAINER pavan
COPY target/swapi-data-lift-service-0.0.1-SNAPSHOT.jar data-lift-service.jar
ENTRYPOINT ["java","-jar","/swapi-data-lift-service.jar"]