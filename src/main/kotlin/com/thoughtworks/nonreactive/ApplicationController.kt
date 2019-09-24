package com.thoughtworks.nonreactive

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture
import org.springframework.web.context.request.async.DeferredResult
import java.util.concurrent.Executors
import java.util.function.Supplier


@RestController
class ApplicationController {

    private val threadPool = Executors.newCachedThreadPool()

    @GetMapping("welcome-delay")
    fun greetWithDelay(): DeferredResult<WelcomeMessage> {
        val deferredResult = DeferredResult<WelcomeMessage>()
        CompletableFuture
                .supplyAsync(Supplier<Any> {
                    Thread.sleep(1000)
                    WelcomeMessage("Hello")
                }, threadPool)
                .whenCompleteAsync{ result, throwable -> deferredResult.setResult(result as WelcomeMessage) }
        return deferredResult
    }
}

data class WelcomeMessage(val message: String)
