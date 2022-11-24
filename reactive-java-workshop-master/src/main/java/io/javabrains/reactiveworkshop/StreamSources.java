package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

/*
 * 
 * DO NOT MODIFY THIS CODE
 *
 */
public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(1, "krishna", "yadav"),
                new User(2, "nilesh", "k"),
                new User(2, "rits", "v"),
                new User(3, "abhisekh", "c"),
                new User(4, "avichal", "s"),
                new User(5, "vishal", "s"),
                new User(6, "avnish", "m")
        );
    }
}
