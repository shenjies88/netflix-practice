FROM openjdk:8
WORKDIR /app
COPY target/*.jar app.jar
CMD ["java", "-jar","-Dspring.profiles.active=docker","app.jar"]