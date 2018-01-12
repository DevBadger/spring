#!/usr/bin/env bash

#Rebuild WireMock image
cd $WORKDIR/Tetris/Docker/wiremock && docker build -t "consensus/flex-wiremock:1.0.0-SNAPSHOT" .

#Check if docker network exists if not create one
[ ! "$(docker ps -a | grep dockercomposefiles_consensus-network)" ] && docker network create dockercomposefiles_consensus-network

#Now that config is running spin up containers again
cd /Users/z002ngh/Projects/devBadger/spring/docker && docker-compose up -d
