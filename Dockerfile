FROM eclipse-temurin:21.0.3_9-jdk AS Build

WORKDIR /root

COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

RUN ./mvnw dependency:go-offline

COPY ./src /root/src

RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:21.0.3_9-jre AS Run

WORKDIR /root
EXPOSE 8080
COPY --from=build /root/target/Recipes-API-0.0.1-SNAPSHOT.jar /root/target/Recipes-API-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/root/target/Recipes-API-0.0.1-SNAPSHOT.jar"]

LABEL maintainer="https://www.linkedin.com/in/yannick-yasuhiro-funes-chavez/"
LABEL version="0.0.1"
LABEL description="This container runs Spring Boot with a custom configuration."