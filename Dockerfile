FROM maven:3.5-jdk-8 as BUILD

COPY pom.xml /usr/src/app/
RUN mvn -f /usr/src/app/pom.xml verify clean --fail-never

COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml verify --batch-mode -DskipTests=true

FROM fabric8/java-alpine-openjdk8-jre:1.5

LABEL maintainer="jesus.cabezas@bennu.cl"

RUN mkdir -p /opt/app && \
    addgroup jesu  && \
    adduser -D -G jesu -h /opt/app -s /bin/false jesu

WORKDIR /opt/app

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_DEBUG_PORT=8787 \
    AB_OFF=true \
    JAVA_APP_JAR=app.jar \
    JAVA_APP_DIR=/opt/app \
    JAVA_OPTIONS="-Djava.security.egd=file:/dev/./urandom -Duser.timezone=America/Santiago"

COPY --from=BUILD  /usr/src/app/target/*.jar app.jar


USER jesu
