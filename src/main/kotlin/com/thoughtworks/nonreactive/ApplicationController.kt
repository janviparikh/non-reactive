package com.thoughtworks.nonreactive

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ApplicationController {

    @GetMapping("welcome-delay")
    fun greetWithDelay(): WelcomeMessage {
                    Thread.sleep(1000)
        return WelcomeMessage("Hello")
    }
}

data class WelcomeMessage(val message: String)
