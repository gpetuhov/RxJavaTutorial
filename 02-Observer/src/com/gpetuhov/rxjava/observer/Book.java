package com.gpetuhov.rxjava.observer;

import java.util.ArrayList;
import java.util.List;

public class Book implements Subject {

    private String name;
    private boolean isAvailable;
    private List<Observer> observers = new ArrayList<>();

    public Book(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        if (this.isAvailable) {
            notifyObservers();
        }
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Book is available");

        if (observers.isEmpty()) {
            System.out.println("No users to notify");
        } else {
            System.out.println("Notifying users...");
            for (Observer observer : observers) {
                observer.update(name);
            }
        }
    }
}
