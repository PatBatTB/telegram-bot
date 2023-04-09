#!/bin/bash

git pull

./gradlew clean
./gradlew build

docker compose stop

export BOT_USERNAME=$1
export BOT_TOKEN=$2
export LOG_PATH=$3

docker compose up --build -d