# AS <NAME> to name this stage as maven
FROM maven:3.6.3 AS maven
LABEL MAINTAINER="elouaer.mohamedamine@gmail.com"

WORKDIR /usr/src/app
COPY target /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn clean package

FROM openjdk:8-jdk-alpine

ARG JAR_FILE=devops-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app

# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","./devops-0.0.1-SNAPSHOT.jar"]