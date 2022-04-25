FROM arm32v7/adoptopenjdk:8

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

USER root

COPY build/libs/*.jar application.jar

EXPOSE 8081

CMD ["java", "-jar", "application.jar"]