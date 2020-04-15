import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

// Hot observables emit items even if there are no subscribers.
// Hot observables in RxJava are called ConnectableObservables.

public class HotObservables {

    public static void main(String[] args) throws InterruptedException {
        // Cold observables are converted into hot observables by calling publish() method.
        ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

        // source will start emitting items after calling connect() methods
        source.connect();

        // Let's wait for a couple of seconds
        Thread.sleep(3000);

        // And now subscribe to our source
        // This print starting from 3
        source.subscribe(System.out::println);

        // Wait for 10 seconds
        Thread.sleep(10000);

        // And subscribe another observer.
        // This one will receive items starting from 13
        source.subscribe(System.out::println);

        Thread.sleep(10000);
    }
}