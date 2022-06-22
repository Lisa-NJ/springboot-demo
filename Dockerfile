FROM openjdk:11

ARG ARTIFACT_VERSION=0.0.1-SNAPSHOT

COPY ./src /app
WORKDIR /app

COPY ./build/libs/demo-${ARTIFACT_VERSION}.jar /app/app.jar
COPY ./scripts/start_dev.sh /app/start_dev.sh

RUN chmod +x /app/start_dev.sh

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "/app/start_dev.sh"]