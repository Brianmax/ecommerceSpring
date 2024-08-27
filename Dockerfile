FROM ghcr.io/graalvm/jdk-community:17
LABEL authors="george"

ENTRYPOINT ["top", "-b"]