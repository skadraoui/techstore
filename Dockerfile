FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/*.jar /app/techstore.jar

ENTRYPOINT ["java", "-jar", "/app/techstore.jar"]
