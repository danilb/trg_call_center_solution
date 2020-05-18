#!/bin/sh

kubectl apply -f artemis_trg_pod.yml
kubectl apply -f artemis_trg_service.yml

sleep 5s

minikube service artemis-service --url