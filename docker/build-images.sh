#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PWD=pwd

MAX_RETRIES=3

#build wiremock
cd /Users/z002ngh/Projects/devBadger/spring/wiremock && docker build -t "com.devbadger/wiremock:1.0.0-SNAPSHOT" .

#build eureka
cd /Users/z002ngh/Projects/devBadger/spring/eureka/ && ./gradlew clean build image jacocoTestReport

#build config
cd /Users/z002ngh/Projects/devBadger/spring/config/ && ./gradlew clean build image jacocoTestReport

#build zuul
cd /Users/z002ngh/Projects/devBadger/spring/zuul/ && ./gradlew clean build image jacocoTestReport

#build gateway
cd /Users/z002ngh/Projects/devBadger/spring/gateway/gateway-app && ./gradlew generateContractTests
cd /Users/z002ngh/Projects/devBadger/spring/gateway && ./gradlew clean build install image jacocoTestReport
cd /Users/z002ngh/Projects/devBadger/spring/gateway/gateway-app && ./gradlew generateClientStubs publishToMavenLocal

#build service
cd /Users/z002ngh/Projects/devBadger/spring/service/service-app && ./gradlew clean build -x test install
cd /Users/z002ngh/Projects/devBadger/spring/service/service-common && ./gradlew clean build -x test install
cd /Users/z002ngh/Projects/devBadger/spring/service && ./gradlew clean build -x test install && ./gradlew build image jacocoTestReport

#build security
#cd /Users/z002ngh/Projects/devBadger/spring/security/ && ./gradlew clean build image jacocoTestReport