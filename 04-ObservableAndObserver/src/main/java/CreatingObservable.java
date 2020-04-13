import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Different ways of creating Observables
public class CreatingObservable {

    public static void main(String[] args) throws InterruptedException {

        // === create ===

        Observable<Integer> source = Observable.create(emitter -> {
            emitter.onNext(10);
            emitter.onNext(11);
            emitter.onComplete();
        });

        // This will print only 10 and 11, because it has no consumer for onComplete
        source.subscribe(System.out::println);

        // === just ===

        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        // === fromIterable ===

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Grape");
        fruits.add("Peach");
        Observable<String> fromIterable = Observable.fromIterable(fruits);

        fromIterable.subscribe(System.out::println);

        // === range ===

        Observable
                .range(3, 10)
                // We may subscribe immediately without creating additional variables
                .subscribe(System.out::println);

        // === interval ===

        Observable
                // This by default runs on the background thread using computation scheduler
                .interval(1000, 1000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        // This is needed to wait for some elements to be emitted
        Thread.sleep(10000);

        // === empty ===

        Observable
                // This will only emit onComplete
                .empty()
                .subscribe(System.out::println, System.out::println, () -> {
                    System.out.println("Empty observable complete");
                });

        // === defer ===

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Potato");
        vegetables.add("Carrot");

        // Here the Observable fromIterable will not be created immediately
        Observable<String> defer = Observable.defer(() -> Observable.fromIterable(vegetables));

        // fromIterable Observable is created only when the Observer subscribes to defer Observable
        defer.subscribe(System.out::println);
    }
}
