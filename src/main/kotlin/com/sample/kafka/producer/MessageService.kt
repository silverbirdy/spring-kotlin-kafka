package com.sample.kafka.producer

import com.sample.kafka.config.KafkaTopicConfig
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun sendMessage(message: Message) {
        kafkaTemplate.send(KafkaTopicConfig.MESSAGE_TOPIC_NAME, message.contents)
    }
}
