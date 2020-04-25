import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Arrays;
import java.util.List;

// ObserveOn will make observable EMISSIONS run on the specifed scheduler
// with unbounded buffer
// (if the consumer works slower, than the producer,
// then observeOn will buffer items emitted by the producer).

public class ObserveOn {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> source = Observable.create((ObservableOnSubscribe<String>) emitter -> {
                    List<String> items = Arrays.asList("Apple", "Grape", "Plum", "Pear", "Apricot");
                    for (String item : items) {
                        // This will run on computation scheduler
                        Thread.sleep(1000);
                        System.out.println("Emit item = " + item + ", Thread: " + Thread.currentThread().getName());
                        emitter.onNext(item);
                    }
                })
                // Upstream will run on computation scheduler
                .subscribeOn(Schedulers.computation())
                // Downstream will run on newThread scheduler
                .observeOn(Schedulers.newThread());

        source.subscribe(item -> receive(item));
        source.subscribe(item -> receive(item));
        source.subscribe(item -> receive(item));
        source.subscribe(item -> receive(item));
        source.subscribe(item -> receive(item));

        Thread.sleep(30000);
    }

    public static void receive(String item) throws InterruptedException {
        // This will run on newThread scheduler
        Thread.sleep(1000);
        System.out.println("Receive item = " + item + ", Thread: " + Thread.currentThread().getName());
    }
}
