import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeConcat {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(item -> "Source 1: " + item);

        Observable<String> source2 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(item -> "Source 2: " + item);

        // This will emit items from source 1 and 2 interleaved
        Observable.merge(source1, source2)
                .subscribe(System.out::println);

        // We may also merge observables like this:
        // source1.mergeWith(source2)

        Thread.sleep(5000);

        System.out.println();

        // This will emit items from source 1 first and then from source 2
        Observable.concat(source1, source2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
