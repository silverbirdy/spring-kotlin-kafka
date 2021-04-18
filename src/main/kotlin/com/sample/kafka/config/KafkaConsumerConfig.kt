package com.sample.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
class KafkaConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {
    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val consumerContainerFactory = ConcurrentKafkaListenerContainerFactory<String, String>()
        consumerContainerFactory.consumerFactory = consumerFactory()
        return consumerContainerFactory
    }

    private fun consumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(consumerProperties())
    }

    private fun consumerProperties(): Map<String, Any> {
        return hashMapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.host,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
        )
    }

    companion object {
        const val GROUP_ID = "sampleGroup"
    }
}
