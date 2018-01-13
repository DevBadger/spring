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

#build security
#cd /Users/z002ngh/Projects/devBadger/spring/security/ && ./gradlew clean build image jacocoTestReport