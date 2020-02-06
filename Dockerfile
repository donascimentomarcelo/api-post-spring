FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/WikiCode-*.jar $PROJECT_HOME/app.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-jar", "-Dspring.profiles.active=prod" ,"./app.jar"]