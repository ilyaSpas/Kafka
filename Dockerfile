FROM openjdk:17-jdk-slim
COPY ./target/kafka-demo-1-0.0.1-SNAPSHOT.jar dir/src/project/kafka-demo-1-0.0.1-SNAPSHOT.jar
WORKDIR dir/src/project
CMD ["java", "-jar", "kafka-demo-1-0.0.1-SNAPSHOT.jar"]