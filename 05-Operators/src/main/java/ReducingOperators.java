import io.reactivex.rxjava3.core.Observable;

public class ReducingOperators {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> source = Observable.just(23, 5, 67, 5, 89, 12, 78, 56, 95, 44);

        source
                // Counts number of emitted items
                .count()
                .subscribe(System.out::println);

        System.out.println();

        source
                // In this case we will get sum of all items
                .reduce((x, y) -> x + y)
                .subscribe(System.out::println);

        System.out.println();

        source
                // return true if emitted sequence contains the element
                .contains(150)
                .subscribe(System.out::println);

        System.out.println();

        source
                // return true if all items satisfy the given predicate
                .all(item -> item < 100)
                .subscribe(System.out::println);

        System.out.println();

        source
                // return true if at least one item satisfies the given predicate
                .any(item -> item < 10)
                .subscribe(System.out::println);
   }
}