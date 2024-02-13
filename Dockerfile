FROM openjdk:latest
COPY ./target/Coursework-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Coursework-1.0-SNAPSHOT-jar-with-dependencies.jar"]