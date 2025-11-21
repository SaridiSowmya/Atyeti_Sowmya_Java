package com.example.webfluxexample.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class TestController {

    @GetMapping("/slow")
    public Mono<String> slow() {
        return Mono.delay(Duration.ofSeconds(5))
                .map(i -> "Done after 5 seconds!");
    }

    @GetMapping("/fast")
    public Mono<String> fast() {
        return Mono.just("Fast response!");
    }
}
