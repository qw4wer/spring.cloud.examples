FROM openjdk:11
ADD target/nacos-producer-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker"]

EXPOSE 8080