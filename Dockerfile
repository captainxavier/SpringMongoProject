# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file to the container
COPY target/SpringMongoProject-0.0.2-SNAPSHOT.jar .

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "SpringMongoProject-0.0.2-SNAPSHOT.jar"]