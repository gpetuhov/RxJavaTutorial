import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class FlatMapConcatMap {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).take(5);

        source
                // flatMap creates an observable from each item emitted by the source
                // and them merges them into one observable.
                // So the resulting items are emitted interleaved.
                .flatMap(item -> {
                    return Observable.interval(500, TimeUnit.MILLISECONDS)
                            .take(5)
                            .map(number -> "Emitted from observable " + item + ": " + number);
                })
                .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
