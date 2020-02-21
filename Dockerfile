FROM openjdk:latest
MAINTAINER gayeomar@hotmail.com
COPY . /cp4i-capstone
WORKDIR /cp4i-capstone
ENTRYPOINT  ["./run.sh"]