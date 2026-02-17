# ===== STAGE 1 : Build =====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copier les fichiers Maven en premier (cache des dépendances)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source et builder
COPY src ./src
RUN mvn clean package -DskipTests

# ===== STAGE 2 : Run =====
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]