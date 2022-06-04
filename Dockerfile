FROM openjdk:18
WORKDIR /app
COPY ./ .
COPY ./target/hrms-0.0.1-SNAPSHOT.jar hrms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","hrms-0.0.1-SNAPSHOT.jar","--spring.profiles.active=docker"]