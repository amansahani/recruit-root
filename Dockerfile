FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

# Copy the .env file into the container
COPY .env .env

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 8888

CMD ["./mvnw", "spring-boot:run"]
