FROM java:8
VOLUME /tmp
ADD provider-0.0.1-SNAPSHOT.jar /provider.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/provider.jar"]