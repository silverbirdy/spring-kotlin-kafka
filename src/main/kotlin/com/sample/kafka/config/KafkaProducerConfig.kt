package com.sample.kafka.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate

@Configuration
@EnableKafka
class KafkaProducerConfig(
    private val kafkaProperties: KafkaProperties
) {
    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(DefaultKafkaProducerFactory(producerProperties()))
    }

    private fun producerProperties(): Map<String, Any> {
        return hashMapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.host,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        )
    }
}
