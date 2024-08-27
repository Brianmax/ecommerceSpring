FROM ubuntu:latest
LABEL authors="george"

ENTRYPOINT ["top", "-b"]