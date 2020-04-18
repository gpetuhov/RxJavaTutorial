import io.reactivex.rxjava3.core.Observable;

public class ActionOperators {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.just(23, 5, 67, 5, 89, 12, 78, 56, 95, 44);

        source
                .doOnNext(item -> System.out.println("Emitting " + item))
                .doOnSubscribe(disposable -> System.out.println("Subscribe"))
                .doOnComplete(() -> System.out.println("Complete"))
                .subscribe(System.out::println);
    }
}