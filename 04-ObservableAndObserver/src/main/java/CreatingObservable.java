import io.reactivex.rxjava3.core.Observable;

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
    }
}
