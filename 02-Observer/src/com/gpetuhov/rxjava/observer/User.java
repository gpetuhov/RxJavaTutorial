package com.gpetuhov.rxjava.observer;

public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String data) {
        System.out.println("Hello, " + name + "! Book " + data + " is now available!");
    }
}
