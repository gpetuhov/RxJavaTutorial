import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {

    public static void main(String[] args) throws InterruptedException {

        // We can create our own scheduler like this
        ExecutorService service = Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(service);

        Observable<String> source = Observable.just("Apple", "Grape", "Plum", "Pear", "Apricot")
                .subscribeOn(scheduler)
                // We have to shutdown our executor service for the program to stop
                .doFinally(service::shutdown);

        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));

        // Note that in this case we don't have to put main thread to sleep to wait for the observers to complete
    }

    public static void compute(String item) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Item = " + item + ", Computation done by thread: " + Thread.currentThread().getName());
    }
}
