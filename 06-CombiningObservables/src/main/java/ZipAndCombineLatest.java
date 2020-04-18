import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS).take(10);
        Observable<Long> source2 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);

        // Zip emits an item every time it receives items from BOTH sources.
        // If one source emits an item and the second source does not,
        // zip will wait for the second source to emit an item to create the resulting item.
        // In this example source1 emits 10 items in 10 seconds,
        // and source2 emits 10 items in 2 seconds.
        // The resulting sequence will emit 10 items in 10 seconds,
        // and each item will be created from the corresponding pair of the source items.
        Observable.zip(source1, source2, (item1, item2) -> "Source 1: " + item1 + ", Source 2: " + item2)
                .subscribe(System.out::println);

        Thread.sleep(10000);

        System.out.println();

        // CombineLatest emits an item every time it receives an item from any of the source
        // by combining latest items received.
        // If there are items from only one source,
        // then combineLatest will wait for the first item from the second source before emitting.
        // All previous items received from the first source will be ignored.
        Observable.combineLatest(source1, source2, (item1, item2) -> "Source 1: " + item1 + ", Source 2: " + item2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
