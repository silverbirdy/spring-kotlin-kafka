package com.sample.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.sample.kafka"])
class SampleApplication

fun main(args: Array<String>) {
    runApplication<SampleApplication>(*args)
}
