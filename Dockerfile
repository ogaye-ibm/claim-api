FROM openjdk:latest
MAINTAINER gayeomar@hotmail.com
COPY . /claim
WORKDIR /claim
ENTRYPOINT  ["./run.sh"]
