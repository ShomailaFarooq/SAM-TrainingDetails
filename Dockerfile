
FROM openjdk:11
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "TrainingDetails-1.0.0.jar"]
