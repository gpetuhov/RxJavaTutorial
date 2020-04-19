import io.reactivex.rxjava3.core.Observable;

public class Grouping {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(234, 33, 4, 23, 78, 23, 4, 33, 234, 4);

        // GroupBy groups items, emitted by the source, into GroupedObservables
        // according to provided criteria.
        source.groupBy(value -> value)
                // Here we use flatMapSingle to convert each GroupedObservable into Single<List<Integer>>
                .flatMapSingle(groupedObservable -> groupedObservable.toList())
                .subscribe(System.out::println);
    }
}
