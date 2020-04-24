import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Schedulers.newThread()
// In computation and io schedulers threads are reused by the observers.
// In newThread scheduler every observer use their own new threads.
// And these threads get destroyed at the end, they are not reused.

public class NewThreadScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("Apple", "Grape", "Plum", "Pear", "Apricot")
                .subscribeOn(Schedulers.newThread());

        source.subscribe(item -> compute(item));

        Thread.sleep(6000);

        // Second observer will not reuse thread of the first observer
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));

        Thread.sleep(10000);
    }

    public static void compute(String item) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Item = " + item + ", Computation done by thread: " + Thread.currentThread().getName());
    }
}
