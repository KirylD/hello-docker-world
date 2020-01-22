FROM openjdk:13-slim

EXPOSE 8080

COPY target/sam-cloud-1.0-SNAPSHOT.jar /usr/java/sam-cloud-1.0-SNAPSHOT.jar

CMD ["java", "-jar", "/usr/java/sam-cloud-1.0-SNAPSHOT.jar"]
