FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

ENTRYPOINT ["./mvnw", "spring-boot:run"]