#!/usr/bin/env bash
PROJDIR="/Users/michaelbadger/IdeaProjects/DevBadger/spring"
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PWD=pwd

MAX_RETRIES=3

#build wiremock
cd $PROJDIR/wiremock && docker build -t "com.devbadger/wiremock:1.0.0-SNAPSHOT" .

#build eureka
cd $PROJDIR/eureka/ && ./gradlew clean build image jacocoTestReport

#build config
cd $PROJDIR/config/ && ./gradlew clean build image jacocoTestReport

#build gateway
cd $PROJDIR/gateway/gateway-icndb-model && ./gradlew clean build install publishToMavenLocal
cd $PROJDIR/gateway/gateway-icndb-service && ./gradlew clean build install
cd $PROJDIR/gateway/gateway-app && ./gradlew generateContractTests
cd $PROJDIR/gateway && ./gradlew clean build install image jacocoTestReport
cd $PROJDIR/gateway/gateway-app && ./gradlew generateClientStubs publishToMavenLocal

#build service
cd $PROJDIR/service
./gradlew clean build -x test install publishToMavenLocal
./gradlew build image jacocoTestReport

#build service
cd $PROJDIR/graphql
./gradlew clean build -x test install publishToMavenLocal
./gradlew build image jacocoTestReport

#build zuul
cd $PROJDIR/zuul/ && ./gradlew clean build image jacocoTestReport