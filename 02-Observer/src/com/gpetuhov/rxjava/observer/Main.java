package com.gpetuhov.rxjava.observer;

public class Main {

    public static void main(String[] args) {
        User bob = new User("Bob");
        User jane = new User("Jane");

        Book dune = new Book("Dune", false);

        System.out.println("Book is unavailable. Subscribe users");
        dune.subscribeObserver(bob);
        dune.subscribeObserver(jane);

        System.out.println("Make book available");
        dune.setIsAvailable(true);

        System.out.println("Unsubscribe users");
        dune.unsubscribeObserver(bob);
        dune.unsubscribeObserver(jane);

        System.out.println("Make book unavailable");
        dune.setIsAvailable(false);

        System.out.println("Make book available again");
        dune.setIsAvailable(true);
    }
}
