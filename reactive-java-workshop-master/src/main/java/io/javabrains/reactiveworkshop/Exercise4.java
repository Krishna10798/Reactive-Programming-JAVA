package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
    	System.out.println("Print the value from intNumberMono when it emits");
//    	ReactiveSources.intNumberMono().subscribe(number->System.out.println(number));
    	
    	//or
//    	ReactiveSources.intNumberMono().subscribe(number->System.out.println(number),
//    			err->System.out.println(err.getMessage()));
    	
    	//or
    	ReactiveSources.intNumberMono().subscribe(number->System.out.println(number),
    			err->System.out.println(err.getMessage()),
    			()->System.out.println("Complete"));

        // Get the value from the Mono into an integer variable
        System.out.println("Get the value from the Mono into an integer variable");
        Integer number=ReactiveSources.intNumberMono().block();
        System.out.println("-------OR------");
        Optional<Integer> number1=ReactiveSources.intNumberMono().blockOptional();
        

        System.out.println("Press a key to end");
        System.in.read();
    }

}
