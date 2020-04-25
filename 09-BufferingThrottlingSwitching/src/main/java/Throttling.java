import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Throttling {

    public static void main(String[] args) throws InterruptedException {

        // ThrottleFirst emits only the first item received during the specified interval
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(20)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(12000);

        System.out.println();

        // ThrottleLast emits only the last item received during the specified interval
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .take(20)
                .throttleLast(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(12000);
    }
}
