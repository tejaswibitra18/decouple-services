#!/bin/sh

docker volume create bb_reviews_local

docker run \
      --rm \
      --platform linux/amd64 \
      -e POSTGRES_HOST_AUTH_METHOD=trust \
      -v bb_reviews_local:/var/lib/postgresql/data \
      --name postgres-bulletinboard-reviews \
      -p 6543:5432 \
      postgres:12-alpine
