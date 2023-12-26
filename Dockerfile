
FROM openjdk:17
WORKDIR /app
ADD target/car-0.0.1-SNAPSHOT.jar car.jar 
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "car.jar"]
