package com.sample.kafka.producer

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(
    private val messageService: MessageService
) {
    @PostMapping("/message/send")
    fun sendMessage(@RequestBody message: Message) {
        messageService.sendMessage(message)
    }
}
