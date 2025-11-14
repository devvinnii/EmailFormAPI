# Dockerfile do BACKEND SaneaRH
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copia o JAR gerado na pasta target
COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
