FROM eclipse-temurin:11-jdk-jammy AS build
VOLUME /tmp

COPY target/*.jar app.jar

# FROM eclipse-temurin:11-jdk-jammy

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]