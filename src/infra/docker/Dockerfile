FROM openjdk:11-slim-buster

ARG JAR_FILE

ENV ARTIFACT_NAME=$JAR_FILE

WORKDIR /app

COPY src/infra/docker/entrypoint.sh /app
COPY target/${JAR_FILE} /app

ENTRYPOINT ["/app/entrypoint.sh"]
