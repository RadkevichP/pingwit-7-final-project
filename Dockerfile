# Use the official OpenJDK 17 image as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/pingwitcarrental-0.0.1-SNAPSHOT.jar /app/carrental.jar

# Expose the port that your application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "carrental.jar"]
