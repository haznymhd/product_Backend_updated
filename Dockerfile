FROM openjdk:11
COPY target/your-spring-boot-app.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
