package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream() //

    	
        // Print all numbers in the intNumbersStream stream
    	System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(e->System.out.println(e));
        System.out.println("-----------OR----------");
        StreamSources.intNumbersStream()
        .forEach(System.out::println);

        
        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
        .filter(number->number<5)
        .forEach(System.out::println);

        
        // Print the 3rd , 4th and 5th numbers in intNumbersStream that's greater than 5
        System.out.println("Print the 3rd , 4th and 5th numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(number->number>5)
        .skip(2)
        .limit(3)
        .forEach(System.out::println);

        
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5.\n"
        		+ " & If nothing is found, print -1");
        Integer value=StreamSources.intNumbersStream()
        		.filter(number->number>5)
        		.findFirst().orElse(-1);
        System.out.println(value);

        
        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream()
        .forEach(user->System.out.println(user.getFirstName()));
        System.out.println("-----------OR----------");
        StreamSources.userStream()
        .map(user->user.getFirstName())
        .forEach(firstName->System.out.println(firstName));

        
        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
        .flatMap(id->StreamSources.userStream().filter(user->user.getId()==id))
        .map(user->user.getFirstName())
        .forEach(userName->System.out.println(userName));
        //"this is what we did in above line....only for code reference"
        System.out.println("this is what we did in above line....only for code reference");
        var stream1=StreamSources.intNumbersStream();
        var stream2=stream1.flatMap(id->StreamSources.userStream().filter(user->user.getId()==id)).map(u->u.getFirstName());
        stream2.forEach(uN->System.out.println(uN));
        System.out.println("-----------OR----------");
        StreamSources.userStream()
        .filter(u->StreamSources.intNumbersStream().anyMatch(i->i==u.getId()))
        .map(user->user.getFirstName())
        .forEach(System.out::println);

    }

}
