FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV DB_HOST 172.17.0.1
ENTRYPOINT ["java","-jar","/app.jar"]