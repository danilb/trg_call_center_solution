#!/bin/sh

docker pull vromero/activemq-artemis:2.12-alpine-latest

docker run -it -d --name artemis-trg-docker \
  -p 30161:8161 \
  -p 30616:61616 \
  -p 30672:5672 \
  -e ARTEMIS_USERNAME=trg \
  -e ARTEMIS_PASSWORD=trg \
  vromero/activemq-artemis