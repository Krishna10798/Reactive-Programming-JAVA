package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/*
 * 
 * DO NOT MODIFY THIS CODE
 *
 */
public class ReactiveSources {

    public static Flux<String> stringNumbersFlux() {
        return Flux.just("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFlux() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFluxWithException() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if (e == 5) throw new RuntimeException("An error happened in the flux");
                    return e;
                });
    }

    public static Mono<Integer> intNumberMono() {
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public static Flux<User> userFlux() {
        return Flux.just(
        		 new User(1, "krishna", "yadav"),
                 new User(2, "nilesh", "k"),
                 new User(2, "rits", "v"),
                 new User(3, "abhisekh", "c"),
                 new User(4, "avichal", "s"),
                 new User(5, "vishal", "s"),
                 new User(6, "avnish", "m")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMono() {
        return Mono.just(
                new User(1, "Lionel", "Messi")
        ).delayElement(Duration.ofSeconds(1));

    }

    public static Flux<String> unresponsiveFlux() {
        return Flux.never();
    }

    public static Mono<String> unresponsiveMono() {
        return Mono.never();
    }

    public static Flux<Integer> intNumbersFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }
}
