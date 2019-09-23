package com.thoughtworks.nonreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NonReactiveApplication

fun main(args: Array<String>) {
	runApplication<NonReactiveApplication>(*args)
}
