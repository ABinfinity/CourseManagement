# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/course-jpa.jar course-jpa.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "course-jpa.jar"]

