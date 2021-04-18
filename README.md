# Kafka Example
- SpringBoot + Kotlin

### Kafka & Zookeeper 실행
```
docker-compose up -d
```

### Input
```
[URL] http://localhost:8080/message/send
[Headers] Content-Type: application/json
[Body]
{
	"contents": "test"
}
```

### Output
```
[INFO] o.a.k.clients.consumer.KafkaConsumer     : Received message - test
```

