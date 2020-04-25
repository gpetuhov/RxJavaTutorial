import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Buffering {

    public static void main(String[] args) throws InterruptedException {

        // Here we will get lists of 4 items
        Observable.range(1, 30)
                .buffer(4)
                .subscribe(System.out::println);

        System.out.println();

        // Here we will get lists of items every 2 seconds
        Observable.interval(500, TimeUnit.MILLISECONDS)
                // Time-based buffer operates on the computation scheduler
                .buffer(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
