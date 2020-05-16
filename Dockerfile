FROM maven:3-jdk-11-openj9 as build
WORKDIR /
VOLUME /tmp
ADD . .
RUN mvn clean package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Fix DNS resolution issues when nss is not installed
RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf

# Set DNS cache to 10 seconds (Cache is permanent by default). Network hosts are volatile in Docker clusters.
RUN grep '^networkaddress.cache.ttl=' /opt/${JAVA_PACKAGE}/jre/lib/security/java.security || echo 'networkaddress.cache.ttl=10' >> /opt/${JAVA_PACKAGE}/jre/lib/security/java.security
ENTRYPOINT ["java", "-jar", "/app.jar"]