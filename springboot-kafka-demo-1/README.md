# springboot-kafka-demo-1: REST to Kafka

`POST /messages?message=hello` -> KafkaTemplate -> topic `greetings` -> @KafkaListener (group `demo`).

## Requirements
- Java 17+
- Docker running (Spring Boot starts the Kafka container from compose.yaml)
- Maven: copy `mvnw`, `mvnw.cmd` and the `.mvn` folder from your quick-start project
  into this folder, or use your IDE's Maven / an installed `mvn`.

## Run (Windows)
    mvnw.cmd spring-boot:run

## Test (second Command Prompt)
    curl -X POST "http://localhost:8082/messages?message=hello"

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


## Application Start up Log represents initialisation and allocation of Topic, Partition, Consumer Group, Consumer 
 Starting KafkaApplication using Java 17.0.3 with PID 14620 (xxxxxxx\kafka-usecase-1\target\classes started by User in F:\WorkSpace-Sep-2026\Kafka\SpringBoot + Kafka\kafka-usecase-1)
 No active profile set, falling back to 1 default profile: "default"
 Using Docker Compose file F:\WorkSpace-Sep-2026\Kafka\SpringBoot + Kafka\kafka-usecase-1\compose.yaml
 There are already Docker Compose services running, skipping startup
 Tomcat initialized with port 8082 (http)
 Starting service [Tomcat]
 Starting Servlet engine: [Apache Tomcat/10.1.46]
 Initializing Spring embedded WebApplicationContext
 Root WebApplicationContext: initialization completed in 2784 ms
 Tomcat started on port 8082 (http) with context path '/'
 Started KafkaApplication in 26.661 seconds (process running for 28.746)
 demo_group_1: partitions assigned: [greetings-0, greetings-1, greetings-2, greetings-3]
 demo_group_1: partitions assigned: [greetings-7, greetings-8, greetings-9]
 demo_group_1: partitions assigned: [greetings-4, greetings-5, greetings-6]
 
 
