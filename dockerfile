FROM openjdk:17
LABEL maintainer ="springboot"
ADD target/MySQL-0.0.1-SNAPSHOT.jar MySQL-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MySQL-0.0.1-SNAPSHOT.jar"]