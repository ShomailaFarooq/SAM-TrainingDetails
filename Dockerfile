FROM maven:3.6.0-jdk-8 as builder
WORKDIR /app
COPY . .
RUN mvn dependency:resolve
RUN mvn clean install


FROM openjdk:11
WORKDIR /app
EXPOSE 8080
# ENTRYPOINT ["java","-jar","/spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar"]
COPY --from=builder /app/target/spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar .
CMD java -jar spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar