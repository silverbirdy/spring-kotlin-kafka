package com.sample.kafka.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("kafka")
@ConstructorBinding
class KafkaProperties(
    val host: String
)
