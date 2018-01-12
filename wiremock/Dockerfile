FROM openjdk:8-jdk-alpine

RUN mkdir -p /app/__files
RUN mkdir -p /app/mappings/proxies
RUN mkdir -p /app/logs

ADD wiremock-standalone-2.11.0.jar /app

EXPOSE 14551

# Run wiremock when the container launches
ENTRYPOINT exec java -jar /app/wiremock-standalone-2.11.0.jar --root-dir=/app --max-request-journal-entries=10003 --port=14551 --verbose --local-response-templating