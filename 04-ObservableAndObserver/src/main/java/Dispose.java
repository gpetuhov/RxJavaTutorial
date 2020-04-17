import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Dispose {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        // Subscribe 2 observers to our observable
        Disposable disposable = source.subscribe(item -> System.out.println("Observer 1 received: " + item));
        source.subscribe(item -> System.out.println("Observer 2 received: " + item));

        // We will see output from both observers

        Thread.sleep(5000);

        // Unsubscribe first observer
        disposable.dispose();

        // Now we will see output from the second observer only

        Thread.sleep(5000);
    }
}
