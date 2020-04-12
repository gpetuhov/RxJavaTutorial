package com.gpetuhov.rxjava.hello;

import io.reactivex.rxjava3.core.Observable;

public class Main {

    public static void main(String[] args) {
        // Subject in RxJava is called Observable
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("RxJava");
        });

        // This is the Observer
        source.subscribe(s -> System.out.println(s));
    }
}