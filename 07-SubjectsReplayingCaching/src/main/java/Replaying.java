import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Replaying {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                // Replay returns a ConnectableObservable (hot observable)
                // replay() caches all items, replay(n) caches only n latest items
                .replay()
                // autoConnect will make our ConnectableObservable subscribe to its source,
                // once an observer subscribes to our ConnectableObservable.
                // If we want immediate subscription, then we should call connect().
                .autoConnect();

        // Subscribe first observer
        source.subscribe(number -> System.out.println("Observer 1: " + number));

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Subscribe second observer.
        // Replay re-emits all items received from the moment autoConnect has been called.
        // So, our second observer will receive items 0, 1, 2, 3, 4 right after it subscribes.
        // And then it will continue receiving items 5, 6, 7, etc at the same time as the first observer.
        source.subscribe(number -> System.out.println("Observer 2: " + number));

        Thread.sleep(5000);
    }
}
