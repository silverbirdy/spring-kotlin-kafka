package com.sample.kafka.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig(
    private val kafkaProperties: KafkaProperties
) {
    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        return KafkaAdmin(kafkaAdminConfig())
    }

    private fun kafkaAdminConfig(): HashMap<String, Any> {
        return hashMapOf(
            AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.host
        )
    }

    @Bean
    fun messageTopic(): NewTopic {
        return NewTopic(MESSAGE_TOPIC_NAME, 1, 1.toShort())
    }

    companion object {
        const val MESSAGE_TOPIC_NAME = "message"
    }
}
