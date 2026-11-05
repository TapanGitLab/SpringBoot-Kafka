# Kafka Use Case 1: REST to Kafka

`POST /messages?message=hello` -> KafkaTemplate -> topic `greetings` -> @KafkaListener (group `demo`).

## Requirements
- Java 17+
- Docker running (Spring Boot starts the Kafka container from compose.yaml)
- Maven: copy `mvnw`, `mvnw.cmd` and the `.mvn` folder from your quick-start project
  into this folder, or use your IDE's Maven / an installed `mvn`.

## Run (Windows)
    mvnw.cmd spring-boot:run

## Test (second Command Prompt)
    curl -X POST "http://localhost:8080/messages?message=hello"

Expected log:
    Sent 'hello' -> partition=0 offset=0
    got: hello

Send again: the offset increases (1, 2, 3 ...).

## Stop Kafka when finished
    docker compose down

## Files
- KafkaApplication.java  - entry point
- KafkaTopicConfig.java  - creates topic `greetings` (1 partition)
- MessageProducer.java   - KafkaTemplate send with async callback
- MessageController.java - REST endpoint
- MessageListener.java   - consumer
