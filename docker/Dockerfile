FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /build 
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls -l /build/target

FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY --from=build /build/target/*.jar /app/books.jar

EXPOSE 8080

ENV DB_URL=jdbc:mysql://db:3306/books

CMD ["java", "-jar", "books.jar", "--spring.datasource.url=${DB_URL}"]
