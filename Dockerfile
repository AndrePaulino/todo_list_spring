FROM eclipse-temurin:11-jdk-jammy AS build

# RUN apt-get update
# RUN apt-get install openjdk-11-jdk -y

COPY . .

# RUN apt-get install maven -y
# RUN mvn clean install

FROM eclipse-temurin:11-jdk-jammy

EXPOSE 8080

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]