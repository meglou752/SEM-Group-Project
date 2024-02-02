FROM openjdk:latest
COPY ./target/production/SEM-Group-Project/com /tmp/com
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.App"]