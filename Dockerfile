FROM openjdk:11
COPY target/Product_Management_Backend.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
