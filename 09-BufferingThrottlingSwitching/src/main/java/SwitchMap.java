import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class SwitchMap {

    public static void main(String[] args) throws InterruptedException {

        // SwitchMap is like flatMap, but it UNSUBSCRIBES form the previous observable after emitting new one.
        // So in this example the source emits items every 2 seconds,
        // switchMap creates observables from them, but emits items only from the latest one.
        Observable.interval(2, TimeUnit.SECONDS)
                .switchMap(item -> Observable.interval(500, TimeUnit.MILLISECONDS))
                .subscribe(System.out::println);

        Thread.sleep(20000);
    }
}
