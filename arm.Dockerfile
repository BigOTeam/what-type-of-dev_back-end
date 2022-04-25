FROM arm32v7/adoptopenjdk:8-jre-hotspot

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/*.jar application.jar

EXPOSE 8081

CMD ["java", "-jar", "application.jar"]