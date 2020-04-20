import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Caching {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                // Cache is like replay, but it returns an Observable,
                // which subscribes to its source, once it is being subscribed to.
                // cache() has no additional parameters.
                .cache();

        source.subscribe(number -> System.out.println("Observer 1: " + number));

        Thread.sleep(5000);

        source.subscribe(number -> System.out.println("Observer 2: " + number));

        Thread.sleep(5000);
    }
}
