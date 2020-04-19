import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class FlatMapConcatMap {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).take(5);

        source
                // flatMap creates an observable from each item emitted by the source
                // and then merges them into one observable.
                // So the resulting items are emitted interleaved.
                .flatMap(item -> getObservable(item))
                .subscribe(System.out::println);

        Thread.sleep(8000);

        System.out.println();

        source
                // concatMap also creates an observable from each item emitted by the source,
                // but concatenates them.
                // Here the resulting sequence will contain items from the first observable,
                // then from the second, and so on.
                .concatMap(item -> getObservable(item))
                .subscribe(System.out::println);

        Thread.sleep(14000);
    }

    private static Observable<String> getObservable(Long item) {
        return Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(5)
                .map(number -> "Emitted from observable " + item + ": " + number);
    }
}
