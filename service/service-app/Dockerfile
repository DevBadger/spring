FROM openjdk:8-jdk-alpine

ENV DOCKERIZE_VERSION v0.3.0

RUN apk add --no-cache curl wget

RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

VOLUME /tmp

ADD target/service-1.0.0-SNAPSHOT-exec.jar app.jar

ENV JAVA_OPTS=""

ENTRYPOINT dockerize -wait tcp://config:8080 -timeout ${TIMEOUT:-240s} && exec java $JAVA_OPTS -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /app.jar