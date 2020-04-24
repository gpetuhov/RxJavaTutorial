import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Schedulers.io()
// For input-output tasks
// Number of threads can be more than the number of processor cores

public class IOScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("Apple", "Grape", "Plum", "Pear", "Apricot")
                .subscribeOn(Schedulers.io());

        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
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
