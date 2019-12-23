FROM openjdk:13-slim

COPY target/sam-cloud-1.0-SNAPSHOT.jar /usr/java/sam-cloud-1.0-SNAPSHOT.jar

VOLUME /custom_volume

CMD ["java", "-jar", "/usr/java/sam-cloud-1.0-SNAPSHOT.jar"]
