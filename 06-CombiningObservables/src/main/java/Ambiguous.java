import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(item -> "Source 1: " + item);

        Observable<String> source2 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(5)
                .map(item -> "Source 2: " + item);

        Observable<String> source3 = Observable.interval(2, TimeUnit.SECONDS)
                .take(5)
                .map(item -> "Source 3: " + item);

        // Amb takes emissions from that observable, which emits first.
        // Here source2 emits first item after 0.5 seconds,
        // source1 - after 1 second and source3 - after 2 seconds.
        // Amb will take items from source2 and ignore items from source1 and source3.
        Observable.amb(Arrays.asList(source1, source2, source3))
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
