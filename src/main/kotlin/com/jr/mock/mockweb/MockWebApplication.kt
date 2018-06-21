package com.jr.mock.mockweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:web-config.properties")
class MockWebApplication

fun main(args: Array<String>) {
	runApplication<MockWebApplication>(*args)
}
