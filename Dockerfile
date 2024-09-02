FROM adrienpessu/docker-maven-postgres as builder
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=builder /app/target/PerinityTestCode.jar /app/PerinityTestCode.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/PerinityTestCode.jar"]
