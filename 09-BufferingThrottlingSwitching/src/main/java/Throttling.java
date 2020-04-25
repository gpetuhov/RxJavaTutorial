import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Throttling {

    public static void main(String[] args) throws InterruptedException {

        // ThrottleFirst emits only the first item received during the specified interval
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
