
FROM openjdk:11
WORKDIR /app
COPY ./target/TrainingDetails-1.0.0.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "TrainingDetails-1.0.0.jar"]
