#!/usr/bin/env bash

cd /Users/z002ngh/Projects/devBadger/spring/docker/ && docker-compose stop

echo "removing any dangling docker images"
docker rmi $(docker images -f dangling=true -q) 2> /dev/null