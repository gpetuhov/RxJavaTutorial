import io.reactivex.rxjava3.core.Observable;

public class ErrorRecoveryOperators {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(23, 5, 67, 5, 89, 12, 78, 56, 95, 44);

        source
                // This will cause an exception
                .cast(Long.class)
                // But this will consume it and return -100 instead
                .onErrorReturnItem(-100L)
                .subscribe(System.out::println);
   }
}