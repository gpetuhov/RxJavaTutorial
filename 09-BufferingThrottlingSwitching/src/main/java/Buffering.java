import io.reactivex.rxjava3.core.Observable;

public class Buffering {

    public static void main(String[] args) throws InterruptedException {

        // Here we will get lists of 4 items
        Observable.range(1, 30)
                .buffer(4)
                .subscribe(System.out::println);
    }
}
