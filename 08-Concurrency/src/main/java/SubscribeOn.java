import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// SubscribeOn lets the observer subscribe to an observable on a particular thread

public class SubscribeOn {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> source = Observable.just("Apple", "Grape", "Plum", "Pear", "Apricot")
                .subscribeOn(Schedulers.computation())
                // If we have two subscribeOn, the closest to the source wins
                // (so in this case we compuation scheduler will be used).
                .subscribeOn(Schedulers.newThread());

        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));
        source.subscribe(item -> compute(item));

        Thread.sleep(30000);
    }

    public static void compute(String item) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Item = " + item + ", Computation done by thread: " + Thread.currentThread().getName());
    }
}
