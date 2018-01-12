#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PWD=pwd

MAX_RETRIES=3

#build eureka
cd /Users/z002ngh/Projects/devBadger/spring/eureka/ && ./gradlew clean build image jacocoTestReport

#build config
cd /Users/z002ngh/Projects/devBadger/spring/config/ && ./gradlew clean build image jacocoTestReport