FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /build 
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine
ARG APP_VERSION=1.0

WORKDIR /app

COPY --from=build /build/target/books-*.jar /app/books.jar

EXPOSE 8080

ENV JAR_VERSION=${APP_VERSION}
ENV DB_URL=jdbc:mysql://db:3306/books

CMD ["java", "-jar", "books.jar", "--spring.datasource.url=${DB_URL}"]
