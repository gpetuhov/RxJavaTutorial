package com.gpetuhov.rxjava.hello;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;

public class Main {

    public static void main(String[] args) {
        // Subject in RxJava is called Observable
        Observable<String> source = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("Hello");
                emitter.onNext("RxJava");
            }
        });

        // This is the Observer
        source.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                System.out.println(s);
            }
        });
    }
}