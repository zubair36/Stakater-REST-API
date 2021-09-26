FROM openjdk:8-jdk-alpine

MAINTAINER Zubair Khan <zubi.umar@gmail.com>

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]