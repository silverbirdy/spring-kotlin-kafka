package com.sample.kafka.consumer

import com.sample.kafka.config.KafkaConsumerConfig
import com.sample.kafka.config.KafkaTopicConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer {
    private val logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

    @KafkaListener(topics = [KafkaTopicConfig.MESSAGE_TOPIC_NAME], groupId = KafkaConsumerConfig.GROUP_ID)
    fun consumeMessage(message: String) {
        logger.info("Received message - $message")
    }
}
