import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

// Different ways of creating Observables
public class CreatingObservable {

    public static void main(String[] args) {

        // === create() ===

        Observable<Integer> source = Observable.create(emitter -> {
            emitter.onNext(10);
            emitter.onNext(11);
            emitter.onComplete();
        });

        // This will print only 10 and 11, because it has no consumer for onComplete
        source.subscribe(System.out::println);

        // === just() ===

        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        // === fromIterable() ===

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Grape");
        fruits.add("Peach");
        Observable<String> fromIterable = Observable.fromIterable(fruits);

        fromIterable.subscribe(System.out::println);
    }
}
