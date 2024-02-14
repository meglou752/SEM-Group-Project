FROM openjdk:latest
COPY ./target/Coursework-Code-Review-1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Coursework-Code-Review-1-jar-with-dependencies.jar"]