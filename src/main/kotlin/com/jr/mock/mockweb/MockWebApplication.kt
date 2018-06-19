package com.jr.mock.mockweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockWebApplication

fun main(args: Array<String>) {
	runApplication<MockWebApplication>(*args)
}
