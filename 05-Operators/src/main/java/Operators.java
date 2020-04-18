import io.reactivex.rxjava3.core.Observable;

public class Operators {

    public static void main(String[] args) {
        Observable.just(23, 6, 67, 5, 89, 12, 78, 56, 95, 44)
                .filter(number -> number > 30)
                .sorted()
                .subscribe(System.out::println);
    }
}
