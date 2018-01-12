#!/usr/bin/env bash

#Rebuild WireMock image
cd /Users/z002ngh/Projects/devBadger/spring/wiremock && docker build -t "com.devbadger/wiremock:1.0.0-SNAPSHOT" .

#Check if docker network exists if not create one
[ ! "$(docker ps -a | grep dockercomposefiles_devbadger-network)" ] && docker network create dockercomposefiles_devbadger-network

#Now that config is running spin up containers again
cd /Users/z002ngh/Projects/devBadger/spring/docker && docker-compose up -d
