import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TransformingOperators {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> source = Observable.just(23, 5, 67, 5, 89, 12, 78, 56, 95, 44);

        source
                .map(item -> item + " * 2 = " + item * 2)
                .subscribe(System.out::println);

        System.out.println();

        source
                // adds a delay before the first item is emitted
                .delay(5, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(6000);

        System.out.println();

        source
                // This will return item[0], item[0] + item[1], item[0] + item[1] + item[2], ...
                .scan((x, y) -> x + y)
                .subscribe(System.out::println);

        System.out.println();

        source
                // Repeat the initial sequence of elements 2 times
                .repeat(2)
                .subscribe(System.out::println);
    }
}