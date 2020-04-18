import io.reactivex.rxjava3.core.Observable;

public class SupressingOperators {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(23, 5, 67, 5, 89, 12, 78, 56, 95, 44);

        source
                .filter(number -> number < 20)
                .distinct()
                .subscribe(System.out::println);

        System.out.println();

        source
                .skip(2)
                .take(5)
                .subscribe(System.out::println);

        System.out.println();

        source
                .elementAt(5)
                .subscribe(System.out::println);
    }
}
